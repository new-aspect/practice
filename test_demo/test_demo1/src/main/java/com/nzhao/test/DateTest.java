package com.nzhao.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nzhao
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

}
