import com.edu.mybatis.entity.Goods;
import com.edu.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicSql {


    public static void main(String asd[]){
        SqlSession sqlSession = null;
        try {
            Map map = new HashMap();
            map.put("categoryId",14);
            map.put("currentPrice",500);
            sqlSession = MyBatisUtils.openSession(false);
            List<Goods> goods = sqlSession.selectList("goods.dynamicsql",map);
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

}
