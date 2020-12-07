package com.nzhao.test;

import com.nzhao.pojo.User;

import java.util.Date;

/**
 * 日期测试
 * @author nzhao
 */
public class DateTest2 {

    public static void main(String[] args) {
        User user = new User(new Date());
        System.out.println(user);
    }
}
