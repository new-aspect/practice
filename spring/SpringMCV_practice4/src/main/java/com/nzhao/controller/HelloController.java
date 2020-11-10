package com.nzhao.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //业务代码
        modelAndView.addObject("msg","Hello SpringMVC");

        // 视图跳转，只需要设置视图的名称，注意，现在跳转到视图解析器，
        // 我们在springmvc-servlet.xml配置了视图解析器InternalResourceViewResolver
        modelAndView.setViewName("test");

        return modelAndView;
    }
}
