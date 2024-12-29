package com.zxl.webexp11.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {
    // 定义一个静态变量，用于持有SqlSessionFactory的实例
    private static SqlSessionFactory sqlSessionFactory = null;

    // 静态初始化块，用于在类加载时初始化SqlSessionFactory
    static {
        try {
            // 使用MyBatis提供的Resources类加载MyBatis的配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 通过SqlSessionFactoryBuilder构建SqlSessionFactory实例
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            // 如果发生异常，打印堆栈跟踪
            e.printStackTrace();
        }
    }

    // 提供一个公共静态方法，用于获取SqlSession实例
    public static SqlSession getSession() {
        // 通过SqlSessionFactory打开一个SqlSession
        return sqlSessionFactory.openSession();
    }
}