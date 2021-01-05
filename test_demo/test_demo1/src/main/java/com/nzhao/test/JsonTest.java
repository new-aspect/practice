package com.nzhao.test;

import com.alibaba.fastjson.JSON;

/**
 * @author 11507
 */
public class JsonTest {
    public static void main(String[] args) {
        String json = "[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": \"55\",\n" +
                "\t\t\t\t\"name\": \"所有虚拟机\",\n" +
                "\t\t\t\t\"icon\": \"box_ztgl.jpg\",\n" +
                "\t\t\t\t\"microIcon\": \"g5_xtsz.png\",\n" +
                "\t\t\t\t\"url\": \"/_web/_virtual/vmvirtual/vmVirtualList.jsp\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": \"51\",\n" +
                "\t\t\t\t\"name\": \"HUAWEI 1号机\",\n" +
                "\t\t\t\t\"icon\": \"box_ztgl.jpg\",\n" +
                "\t\t\t\t\"microIcon\": \"g5_xtsz.png\",\n" +
                "\t\t\t\t\"url\": \"/_web/_virtual/vmvirtual/vmVirtualList1.jsp\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": \"52\",\n" +
                "\t\t\t\t\"name\": \"HUAWEI 2号机\",\n" +
                "\t\t\t\t\"icon\": \"box_ztgl.jpg\",\n" +
                "\t\t\t\t\"microIcon\": \"g5_xtsz.png\",\n" +
                "\t\t\t\t\"url\": \"/_web/_virtual/vmvirtual/vmVirtualList2.jsp\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": \"53\",\n" +
                "\t\t\t\t\"name\": \"DELL 1号机\",\n" +
                "\t\t\t\t\"icon\": \"box_ztgl.jpg\",\n" +
                "\t\t\t\t\"microIcon\": \"g5_xtsz.png\",\n" +
                "\t\t\t\t\"url\": \"/_web/_virtual/vmvirtual/vmVirtualList3.jsp\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": \"54\",\n" +
                "\t\t\t\t\"name\": \"DELL 2号机\",\n" +
                "\t\t\t\t\"icon\": \"box_ztgl.jpg\",\n" +
                "\t\t\t\t\"microIcon\": \"g5_xtsz.png\",\n" +
                "\t\t\t\t\"url\": \"/_web/_virtual/vmvirtual/vmVirtualList4.jsp\"\n" +
                "\t\t\t}\n" +
                "\t\t]";

        Object o = JSON.parse(json);
        System.out.println(o);
    }
}
