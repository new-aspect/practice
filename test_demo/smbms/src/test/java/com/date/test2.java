package com.date;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List params = new ArrayList();
        integerList.add(4);
        integerList.add(5);
        params.add(3);
        params.add(integerList);
        System.out.println(params.toArray()[1]);
    }
}
