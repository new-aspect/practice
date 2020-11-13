package com.nzhao.controller;

import com.nzhao.util.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Hello7Controller {

    @RequestMapping("/hello7")
    public String hello(){
        Date date = new Date();
        return JsonUtil.getJson(date);
    }

}
