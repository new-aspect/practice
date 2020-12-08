package com.nzhao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nzhao
 */
public class DateTest3 {
    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-2");
        System.out.println(date);
    }
}
