package com.nzhao.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserTestController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","nzhao");

        //
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
