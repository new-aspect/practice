package com.date;

import java.util.HashMap;
import java.util.Map;

public class test6 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("b","4");
        map.put("a","5");
        map.put("c","3");
        map.put("d","5");

        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key+"  "+value);
        }

        System.out.println("35 % 7 = "+ 35%7);
    }
}
