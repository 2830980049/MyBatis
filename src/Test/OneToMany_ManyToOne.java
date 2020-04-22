import com.edu.mybatis.entity.Goods;
import com.edu.mybatis.entity.GoodsDetail;
import com.edu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class OneToMany_ManyToOne {
    @Test
    public void OneToMany(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<Goods> goods = sqlSession.selectList("goods.selectOneToMany");
            for (Goods goods1:goods)
                System.out.println(goods1.getTitle()+" "+goods1.getGoodsDetailList().size());
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
    public void ManyToOne(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            List<GoodsDetail> goodsDetails = sqlSession.selectList("goodsDetail.selectManyToOne");
            for (GoodsDetail goodsDetails1:goodsDetails)
                System.out.println(goodsDetails1.getGdId()+" "+goodsDetails1.getGoods().getTitle());
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
