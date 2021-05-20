package com.date;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class test7 {
    public static void main(String[] args) {
        try {
            File file = new File("db.properties");
            System.out.println(file.getAbsolutePath());
            //InputStream inputStream = test7.class.getResourceAsStream("db.properties");
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("运行成功");
    }
}
