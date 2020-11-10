package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/helloController")
    public String hello(Model model){
        //封装数据
        // 向模型中添加的属性msg与值，可以在jsp页面取出并渲染
        model.addAttribute("msg","Hello, SpringAnnotation");

        return "helloJsp";//会被视图解析器处理，
        // 也就是配置的视图解析器会在这个hello的前缀加/WEB-INF/jsp/
        // 后缀加 .jsp 形成完整的路径  /WEB-INF/jsp/helloJsp.jsp
    }
}
