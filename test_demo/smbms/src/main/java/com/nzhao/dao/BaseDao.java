package com.nzhao.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的基类
 * @author 11507
 */
public class BaseDao {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    // 静态代码块，类初始化的时候就加载
    static{
        // 通过类加载器读取对应资源
        InputStream inStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取链接
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 编辑查询公共类
     */
    public static ResultSet excute(Connection connection, String sql, Object[] params, ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        // 预编译的SQL, 在后面直接执行就可以了, preparedStatement和statement的区别是preparedStatement可以防止sql注入，效率更高
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            // setObject, 占位符从1开始，但是我们的数组是从0开始
            preparedStatement.setObject(i+1, params[i]);
        }
        // 注意这里的bug，写preparedStatement.executeQuery(sql)是报错的，因为多传了一个参数
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    /**
     * 编写增删改工具类
     */
    public static int execute(Connection connection, String sql, Object[] params, PreparedStatement preparedStatement) throws SQLException {
        // 预编译的SQL, 在后面直接执行就可以了
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            // setObject, 占位符从1开始，但是我们的数组是从0开始
            preparedStatement.setObject(i+1, params);
        }

        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }

    /**
     * 释放连接
     */
    public static boolean release(Connection connection, Statement statement, ResultSet resultSet) {
        boolean flag = true;

        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }
}
