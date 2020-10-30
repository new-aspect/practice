package com.nzhao;

import com.nzhao.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class DruidTest {
    public static void main(String[] args) throws SQLException {
        //通过Spring获取Druid连接池对象
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        //对Druid连接池对象进行操作测试
        Connection connection = dataSource.getConnection();
        System.out.println("连接数据源测试 "+connection);
    }
}

