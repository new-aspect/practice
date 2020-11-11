package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    //第一种，之前的风格 http://localhost:8080/helloController?a=1&b=2  得到 a+b=3
//    @RequestMapping("/helloController")
//    public String hello(Model model, int a ,int b){
//        //设置视图
//        model.addAttribute("msg","a + b = "+(a+b));
//
//        //转发视图
//        return "testJsp";
//    }

    //第二种，Restful风格 http://localhost:8080/helloController/1/2  得到 a+b=3
//    @RequestMapping("/helloController/{a}/{b}")
//    public String hello(Model model, @PathVariable("a") int a, @PathVariable("b") int b){
//        //设置视图
//        model.addAttribute("msg","a + b = "+(a+b));
//        //转发视图
//        return "testJsp";
//    }

    //不同访问请求的方式，比如GET, POST, PUT, DELETE 等方式
    //@RequestMapping(value = "/helloController/{a}/{b}",method = RequestMethod.POST)
    @PostMapping("/helloController/{a}/{b}")
    public String hello(Model model, @PathVariable("a") int a, @PathVariable("b") int b){
        //设置视图
        model.addAttribute("msg","a + b = "+(a+b));
        //转发视图
        return "testJsp";
    }
}
