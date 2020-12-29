package com.nzhao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 11507
 */
public class JdbcUtils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    //驱动只用加载一次，所以放到static目录下
    static{
        InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);

            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("password");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnector() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 释放连接
     */
    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(connection != null) {
            connection.close();
        }
        if(statement != null){
            statement.close();
        }
        if(resultSet != null) {
            resultSet.close();
        }
    }
}
