package com.nzhao.test;

import java.util.ArrayList;

public class listTest {
    public static void main(String[] args) {
        ArrayList li = new ArrayList();
        li.add("c");
        li.add("a");
        li.add("z");
        li.add("p");
        li.add("1");

        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
        }

    }
}
