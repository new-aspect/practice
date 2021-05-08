package com.nzhao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 11507
 */
public class JDBCTest2 {
    public static void main(String[] args) {
        /**
         * 注意这里应该先获取ClassLoader，然后获取ResourceAsStream("db.properties")
         */
        InputStream inputStream = JDBCTest2.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        String sql = "select * from table1";
        try {
            // 获取jdbc所需的参数
            properties.load(inputStream);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");

            // 操作jdbc
            Connection connection = DriverManager.getConnection(url, username, password);
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
            while (resultSet.next()) {
                int a = resultSet.getInt("a");
                String b = resultSet.getString("b");
                float c = resultSet.getFloat("c");
                System.out.println("a = " + a + " b = " + b + " c = " + c);
            }
            connection.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
