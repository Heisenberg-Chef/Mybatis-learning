package com.ray.utils;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


// SqlSessionFactory -> SqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlsessionfactory;

    static{
        String resource = "mybatis-config.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 抽象工厂模式
             sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
    }

    public static SqlSession getSqlSession()
    {
        SqlSession session =  sqlsessionfactory.openSession(true);
        if(session == null)
        {
            System.out.println("SqlSession null");
        }
        return session;
    }
}
