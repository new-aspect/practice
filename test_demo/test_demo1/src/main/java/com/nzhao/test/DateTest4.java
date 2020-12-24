package com.nzhao.test;

import com.sudytech.system.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ningzhao
 */
public class DateTest4 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("2020-12-29");
        Date date = simpleDateFormat.parse("2020-12-29");
        System.out.println(date);

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("2020-12-29");
        Date date2 = simpleDateFormat.parse("2020-12-29");
        System.out.println(date2);

        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("2020-12-29");
        Date date3 = simpleDateFormat3.parse("2020-12-29");
        System.out.println(date3);

        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("2020-12-29");
        Date date4 = simpleDateFormat3.parse("2020-12-29");
        System.out.println(date4);

        SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("2020-12-29");
        Date date5 = simpleDateFormat3.parse("2020-12-29");
        System.out.println(date4);


    }
}
