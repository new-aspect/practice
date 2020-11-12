package com.nzhao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nzhao.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody// 添加ResponseBody就不会走视图解析器，会直接返回一个字符串
    public String hello() throws JsonProcessingException {

        //创建User对象，查看直接返回字符串的效果
        User user = new User(1, "nzhao", 33);

        //使用Jackson提供的ObjectMapper，将Java对象转换为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        return json;
    }
}
