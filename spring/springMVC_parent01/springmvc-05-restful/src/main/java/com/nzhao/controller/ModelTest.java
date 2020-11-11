package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试SpringMVC的转发和重定向
 */
@Controller
public class ModelTest {

    /**
     * 转发：没有视图解析器
     * @return
     */
    @RequestMapping("/testController")
    public String test(Model model){
        model.addAttribute("msg","转发：没有视图解析器");
        return "/WEB-INF/jsp/testJsp.jsp";
    }

    /**
     * 重定向，没有视图解析器
     */
    @RequestMapping("/test2Controller")
    public String test2(Model model){
        model.addAttribute("msg","重定向，没有视图解析器");
        return "redirect:/index.jsp";
    }

}
