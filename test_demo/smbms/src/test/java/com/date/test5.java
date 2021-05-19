package com.date;

public class test5 {
    public static void main(String[] args) {
        String s = "101-22";
        String[] split = s.split("-");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split.length);
    }
}
