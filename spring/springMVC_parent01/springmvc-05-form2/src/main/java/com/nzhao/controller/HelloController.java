package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = "/form", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(String name, Model model) {
        System.out.println("HelloController 中的 name = " + name);
        // 模型中添加msg属性
        model.addAttribute("msg",name);
        // 转发视图，视图处理器会拼接成/WEB-INF/jsp/test.jsp
        return "test";
    }
}
