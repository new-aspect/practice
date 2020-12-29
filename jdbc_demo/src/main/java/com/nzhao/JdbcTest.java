package com.nzhao;

import java.sql.*;

/**
 * @author 11507
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1. 加载驱动，这里是通过反射的方式实现

        Class.forName("com.mysql.jdbc.Driver");

        //2. 用户登录信息
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "123456";

        //3. 连接成功后创建数据库连接对象connection
        Connection connection = DriverManager.getConnection(url, username, password);

        //4. 获得执行sql的对象 statement
        Statement statement = connection.createStatement();

        //5. 执行sql
        String sql = "SELECT * FROM `users`;";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println("id = "+resultSet.getObject("id"));
            System.out.println("name = "+resultSet.getObject("name"));
            System.out.println("password = "+resultSet.getObject("password"));
            System.out.println("email = "+resultSet.getObject("email"));
            System.out.println("birthday = "+resultSet.getObject("birthday"));
        }

        //6. 释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
