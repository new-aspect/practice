package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/helloController")
    public String hello(Model model){

        //？？
        model.addAttribute("msg","hello SpringMVC ");

        //转发视图
        return "testJsp";
    }
}
