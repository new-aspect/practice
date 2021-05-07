package com.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test3 {
    public static void main(String[] args) {
        try {
            connectToAndQueryDatabase("root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void connectToAndQueryDatabase(String username, String password) throws Exception{

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false",
                username,
                password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

        while (rs.next()) {
            int x = rs.getInt("a");
            String s = rs.getString("b");
            float f = rs.getFloat("c");
            System.out.println("x = "+x+" s = "+s+" f = "+f);
        }
    }

}
