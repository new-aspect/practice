package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {

    @RequestMapping("/form")
    public String form(String name, Model model){
        System.out.println(name);//用于在后台打印哪里出了问题
        model.addAttribute("msg",name);
        return "test";
    }
}
