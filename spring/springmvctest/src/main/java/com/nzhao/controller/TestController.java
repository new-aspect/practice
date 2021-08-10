package com.nzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /**
     * http://localhost:8088/springmvctest/test1 可以进入方法
     */
    @RequestMapping("/test1")
    public void test(){
        System.out.println("测试能访问到test1");
    }

    /**
     * http://localhost:8088/springmvctest/test2 可以进入方法，flowId=null，注意，第一次无法进入重启后就可以进入了
     * http://localhost:8088/springmvctest/test2&flowId=2 结果是404，表示服务器没有找到目标资源
     * http://localhost:8088/springmvctest/test2?flowId=3 结果可以进入方法，flowId=3
     * http://localhost:8088/springmvctest/test2?name=hello&flowId=4 结果可以进入方法，flowId=4
     * @param flowId
     */
    @RequestMapping("/test2")
    public void test(String flowId){
        System.out.println("flowId = "+flowId);
    }

    /**
     * http://localhost:8088/springmvctest/test3?flowId=3 错误500，
     * @param flowId
     */
    @RequestMapping("/test3")
    public void test2(@PathVariable String flowId){
        System.out.println("flowId = "+flowId);
    }

    /**
     * http://localhost:8088/springmvctest/test4/5 进入方法内，这个时候flowId就是5
     * @param flowId
     */
    @RequestMapping("/test4/{flowId}")
    public void test4(@PathVariable String flowId){
        System.out.println("flowId = "+flowId);
    }


}
