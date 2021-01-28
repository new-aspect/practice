package com.nzhao;

import org.apache.commons.lang3.StringUtils;

public class Test {
    public static void main(String[] args) {
        String name = "李四";
        System.out.println("name = "+name);

        /**
         * 是否为 null
         * 是否为 ""
         * 是否为空字符串(引号中间有空格)  如： "     "。
         * 制表符、换行符、换页符和回车
         */
        String str1 = null;
        String str2 = "";
        String str3 = "  ";

        if (StringUtils.isNotBlank(str1)) {
            String str = str1.trim();
            System.out.println("str1 = " + str);
        }
        if (StringUtils.isNotBlank(str2)) {
            String str = str2.trim();
            System.out.println("str2 = " + str);
        }
        if (StringUtils.isNotBlank(str3)) {
            String str = str3.trim();
            System.out.println("str3 = " + str);
        }
    }
}
