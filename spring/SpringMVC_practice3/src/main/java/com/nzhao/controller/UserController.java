package com.nzhao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/user")
public class UserController {

//    @RequestMapping("/login")
    public String login(){
        //1. 接受请求

        //2. 调用service的业务
        System.out.println("调用业务了");
        //3. 转发业务
        return null;
    }
}
