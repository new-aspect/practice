package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    /**
     * 尝试自己写一个过滤器解决post乱码问题
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/form",method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(String name ,Model model){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "test";
    }

}
