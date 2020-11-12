package com.nzhao.controller;

import com.nzhao.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody// 添加ResponseBody就不会走视图解析器，会直接返回一个字符串
    public String hello(){

        //创建User对象，查看直接返回字符串的效果
        User user = new User(1, "nzhao", 33);

        return user.toString();
    }
}
