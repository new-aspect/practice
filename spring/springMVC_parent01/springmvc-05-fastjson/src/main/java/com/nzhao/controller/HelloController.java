package com.nzhao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @RequestMapping("/hello1")
    public String hello11(){
        Date date = new Date();
        return JSON.toJSONString(date);//1605233846732
    }

    @RequestMapping("/hello2")
    public String hello12(){
        Date date = new Date();
        return JSON.toJSONStringWithDateFormat(date,"yyyy-MM-dd HH:mm:ss", SerializerFeature.EMPTY);
    }

}
