package com.nzhao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 11507
 */
public class JDBCTest {
    // 参数
    static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    static String user = "root";
    static String password = "123456";
    static String sql = "select * from table1";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
        while (resultSet.next()) {
            int a = resultSet.getInt("a");
            String b = resultSet.getString("b");
            float c = resultSet.getFloat("c");
            System.out.println("a = "+a+" b = "+b+" c = "+c);
        }
        connection.close();

    }
}
