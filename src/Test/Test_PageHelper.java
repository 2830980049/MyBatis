import com.edu.mybatis.entity.Goods;
import com.edu.mybatis.utils.MyBatisUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test_PageHelper {

    @Test
    public void TestPageHelper(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession(false);
//          startPage方法 自动将下一次查询进行分页
//          第一个表示第几页  第二个表示查询个数
            PageHelper.clearPage();
            PageHelper.startPage(1,10);
            Page<Goods> page = (Page)sqlSession.selectList("goods.selectPages");
            System.out.println("总页数："+page.getPages());
            System.out.println("总记录数："+page.getTotal());
            System.out.println("开始行号："+page.getStartRow());
            System.out.println("结束行号："+page.getEndRow());
            System.out.println("当前页码："+page.getPageNum());
            //当前页数据
            List<Goods> goods = page.getResult();
            for (Goods goods1:goods)
                System.out.println(goods1);
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
