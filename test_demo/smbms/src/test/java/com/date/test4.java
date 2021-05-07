package com.date;

import java.sql.*;

public class test4 {
    public static void main(String[] args) {
        try {
            connectToAndQueryDatabase(
                    "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
                    "root",
                    "123456"
                    );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void connectToAndQueryDatabase(String url, String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from table1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int a = resultSet.getInt("a");
            String b = resultSet.getString("b");
            float c = resultSet.getFloat("c");
            System.out.println("a = "+a+" b = "+b+" c = "+c);
        }
    }
}
