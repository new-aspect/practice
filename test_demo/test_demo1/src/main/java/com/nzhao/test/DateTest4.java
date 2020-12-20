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
    }
}
