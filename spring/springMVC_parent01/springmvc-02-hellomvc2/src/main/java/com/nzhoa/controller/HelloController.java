package com.nzhoa.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是SpringMVC的一个演示
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView模型和视图
        ModelAndView modelAndView = new ModelAndView();

        // 封住对象，就在ModelAndView
        modelAndView.addObject("msg","Hello SpringMVC");

        //设置对象名称
        modelAndView.setViewName("hello");

        return modelAndView;
    }
}
