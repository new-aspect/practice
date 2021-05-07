package com.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
//        String thisMonth = new SimpleDateFormat("yyyy-MM").format(new Date()) + "-01";
//        System.out.println(thisMonth);


        // Scanner in = new Scanner(System.in);
        //单引号
        String str1="I\'love\'working!";
        //双引号
        String str2="I\"love\"working!";
        //反斜线
        String str3="I\\love\\working!";
        //制表符
        String str4="I\tlove\tworking!";
        //回退符
        String str5="I \blove \bworking!";
        //回车符:将当前位置移到本行开始:故会覆盖\r之前输出的字符
        String str6="I\rlove\rworking!";
        //走纸符
        String str7="I\flove\fworking!";
        //换行符:将当前位置移到下一行开始
        String str8="I\nlove\nworking!";

        //输出:
        System.out.println("单引号--------------");
        System.out.println(str1);
        System.out.println();

        System.out.println("双引号--------------");
        System.out.println(str2);
        System.out.println();

        System.out.println("反斜线--------------");
        System.out.println(str3);
        System.out.println();

        System.out.println("制表符--------------");
        System.out.println(str4);
        System.out.println();

        System.out.println("回退符--------------");
        System.out.println(str5);
        System.out.println();

        System.out.println("回车符--------------");
        System.out.println(str6);
        System.out.println();

        System.out.println("走纸符--------------");
        System.out.println(str7);
        System.out.println();

        System.out.println("换行符--------------");
        System.out.println(str8);
        System.out.println();


    }
}
