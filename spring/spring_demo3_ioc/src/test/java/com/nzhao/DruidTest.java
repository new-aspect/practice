package com.nzhao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DruidTest {
    public static void main(String[] args) throws SQLException {
        //通过Spring获取Druid数据库连接池
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource druidDataSource = applicationContext.getBean(DruidDataSource.class);
        //操作数据库连接池，测试能否连接成功
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println("打印Druid连接信息  " + connection);
    }
}
