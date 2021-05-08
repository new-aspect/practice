package com.nzhao;

import java.io.IOException;
import java.io.InputStream;
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
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("username"));

    }
}
