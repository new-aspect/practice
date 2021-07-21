package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注意，@RestController是@Controller和@ResponseBody的结合，表示返回字符串
 * 当一个类所有接口都需要返回json，不需要返回渲染页面时  直接在类上使用@RestController 就可以。
 * 当有部分接口需要返回json,另一部分返回渲染页面时，在类上注解@Controller，需要返回json的接口在方法上使用注解@ResponseBody配合就可以了。
 */
@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "success";
    }

}
