package com.nzhao.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式测试
 * @author nzhao
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(format);
    }

}
