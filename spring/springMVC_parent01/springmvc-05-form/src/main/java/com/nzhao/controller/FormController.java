package com.nzhao.controller;

import com.nzhao.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

//    @RequestMapping("/form")
//    public String hello(String name){
//        System.out.println(name);
//        return "helloJsp";
//    }

//    @RequestMapping("/form")
//    public String hello(@RequestParam("username") String name){
//        System.out.println(name);
//        return "helloJsp";
//    }

    @RequestMapping("/form")
    public String hello(User user){
        System.out.println(user);
        return "helloJsp";
    }

}
