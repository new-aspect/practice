package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {

    @GetMapping("/form")
    public String form(String name, Model model){
        System.out.println(name);//用于在后台打印哪里出了问题
        model.addAttribute("msg",name);
        return "test";
    }

    @PostMapping("/form")
    public String form2(String name, Model model){
        System.out.println(name);//用于在后台打印哪里出了问题
        model.addAttribute("msg",name);
        return "test";
    }
}
