package com.edu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 创建全局唯一的SqlSessionFactory对象
 */
public class MyBatisUtils {
    //利用static属于类不属于对象,且全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;

    //利用静态快初始化类实例化SqlSessionFactory
    static {
        Reader reader = null;
        try {
            //利用Reader加载classpath下的mybatis-config.xml核心配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            ////初始化SqlSessionFactory对象，同时解析mybatis-config.xml文件
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
                e.printStackTrace();
                //初始化错误，通过抛出ExceptionInInitializerError通知调用者
                throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 创建SqlSession对象，SqlSession是JDBC扩展类，用于与数据交互
     *
     */
    public static SqlSession openSession(boolean n){
        // 默认对事务自动提交
        // 设置false代表关闭自动提交
        if (n)
            return sqlSessionFactory.openSession(false);
        return sqlSessionFactory.openSession();
    }

    public static void closeSession(SqlSession sqlSession){
        //如果type = "POOLED",close将连接回收到连接池中
        //如果type = "UNPOOLED",关闭连接
        if (sqlSession != null)
            sqlSession.close();
    }
}
