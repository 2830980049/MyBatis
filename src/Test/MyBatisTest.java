import com.edu.mybatis.Dto.GoodsDTO;
import com.edu.mybatis.entity.*;
import com.edu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void SqlSessionFactory() throws IOException {
        //利用Reader加载classpath下的mybatis-config.xml核心配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //初始化SqlSessionFactory对象，同时解析mybatis-config.xml文件
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession对象，SqlSession是JDBC扩展类，用于与数据交互
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Connection con = sqlSession.getConnection();
            System.out.println(con);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (sqlSession != null){
                //如果type = "POOLED",close将连接回收到连接池中
                //如果type = "UNPOOLED",关闭连接
                sqlSession.close();
            }
        }
    }

    @Test
    public void MyBatisUntils(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            Connection con = sqlSession.getConnection();
            System.out.println(con);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void GoodsSelectAll(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<Goods> goods = sqlSession.selectList("goods.selectAll");
            for (Goods goods1:goods)
                System.out.println(goods1);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void GoodsSelectById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            Goods goods = sqlSession.selectOne("goods.selectById",1602);
            System.out.println(goods);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void GoodsselectByPriceRange(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            Map map = new HashMap();
            map.put("min",100);
            map.put("max",500);
            map.put("limit",10);
            List<Goods> goods = sqlSession.selectList("goods.selectByPriceRange",map);
            for (Goods goods1:goods)
                System.out.println(goods1.getTitle()+": "+goods1.getCurrentPrice());
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void selecrGoodsMap(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<Map> goods = sqlSession.selectList("goods.selecrGoodsMap");
            for (Map goods1:goods)
                System.out.println(goods1);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void selecrGoodsDTO(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<GoodsDTO> goods = sqlSession.selectList("goods.selectGoodsDTO");
            for (GoodsDTO goods1:goods)
                System.out.println(goods1.getGoods().getTitle()+" "+goods1.getCategory().getCategoryName());
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void Inserts(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(true);
            Goods goods = new Goods();
            goods.setTitle("测试商品");
            goods.setSubTitle("测试子标题");
            goods.setOriginalCost(200f);
            goods.setCurrentPrice(100f);
            goods.setDiscount(0.5f);
            goods.setIsFreeDelivery(1);
            goods.setCategoryId(43);
            int num = sqlSession.insert("goods.insert",goods);
            sqlSession.commit();
            System.out.println(goods.getGoodsId());
        }
        catch (Exception e){
            if (sqlSession != null)
                sqlSession.rollback();
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void update(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(true);
            Goods goods = new Goods();
            goods = sqlSession.selectOne("goods.selectById",739);
            goods.setTitle("更新测试商品");
            int num = sqlSession.insert("goods.update",goods);
            sqlSession.commit();
        }
        catch (Exception e){
            if (sqlSession != null)
                sqlSession.rollback();
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void delete(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(true);
            Goods goods = new Goods();
            int num = sqlSession.insert("goods.delete",739);
            sqlSession.commit();
        }
        catch (Exception e){
            if (sqlSession != null)
                sqlSession.rollback();
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }


    @Test
    public void InsertCategory(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(true);
            Category category = new Category();
            category.setCategoryLevel(1);
            category.setCategoryName("显卡");
            category.setParentId(null);
            category.setCategoryOrder(500);
            int num = sqlSession.insert("category.insert",category);
            sqlSession.commit();
            System.out.println(category.getCategoryId());
        }
        catch (Exception e){
            sqlSession.rollback();
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void CategorySelectAll(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.openSession(false);
            List<Category> categories = sqlSession.selectList("category.selectAll");
            for (Category category:categories)
                System.out.println(category);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void GoodsCoverSelectAll(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<GoodsCover> goodsCovers = sqlSession.selectList("goodsCover.selectAll");
            for (GoodsCover goodsCover:goodsCovers)
                System.out.println(goodsCover);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void GoodsDetailSelectAll(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<GoodsDetail> goodsDetails = sqlSession.selectList("goodsDetail.selectAll");
            for (GoodsDetail goodsDetail:goodsDetails)
                System.out.println(goodsDetail);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void ParpamSelectAll(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<GoodsParam> goodsParams = sqlSession.selectList("goodsParam.selectAll");
            for (GoodsParam goodsParam:goodsParams)
                System.out.println(goodsParam);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

}
