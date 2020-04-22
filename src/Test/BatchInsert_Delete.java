import com.edu.mybatis.entity.Goods;
import com.edu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BatchInsert_Delete {
    @Test
    public void Inserts(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(true);
            Goods goods = new Goods();
            List list  = new ArrayList();
            for (int i = 0; i < 100; i++) {
                goods.setTitle("测试商品");
                goods.setSubTitle("测试子标题");
                goods.setOriginalCost(200f);
                goods.setCurrentPrice(100f);
                goods.setDiscount(0.5f);
                goods.setIsFreeDelivery(1);
                goods.setCategoryId(43);

                list.add(goods);
            }
            int num = sqlSession.insert("goods.batchInsert",list);
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
    public void Deletes(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(true);
            Goods goods = new Goods();
            List list  = new ArrayList();
            for (int i = 1920; i <= 2020; i++) {
                list.add(i);
            }
            int num = sqlSession.insert("goods.batchdelete",list);
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
}
