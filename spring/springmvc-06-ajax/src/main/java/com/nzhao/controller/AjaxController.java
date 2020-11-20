package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

    @RequestMapping("/ajaxTest")
    @ResponseBody
    public String ajaxTest(String name){
        System.out.println("=> name = "+name);
        return "success";
    }
}
