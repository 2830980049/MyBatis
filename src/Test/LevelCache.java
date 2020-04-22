import com.edu.mybatis.entity.Goods;
import com.edu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class LevelCache {
    @Test
    public void Lev1Cache(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            Goods goods = sqlSession.selectOne("goods.selectById",1602);
            Goods goods1 = sqlSession.selectOne("goods.selectById",1602);
            System.out.println(goods.hashCode()+" "+goods1.hashCode());
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }

        try {
            sqlSession = MyBatisUtils.openSession(false);
            Goods goods = sqlSession.selectOne("goods.selectById",1602);
            sqlSession.commit();
            Goods goods1 = sqlSession.selectOne("goods.selectById",1602);
            System.out.println(goods.hashCode()+" "+goods1.hashCode());
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void Lev2Cache(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
            Goods goods = sqlSession.selectOne("goods.selectById",1602);
            System.out.println(goods.hashCode());
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }

        try {
            sqlSession = MyBatisUtils.openSession(false);
            Goods goods = sqlSession.selectOne("goods.selectById",1602);
            System.out.println(goods.hashCode());
        }
        catch (Exception e){
            throw e;
        }
        finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }
}
