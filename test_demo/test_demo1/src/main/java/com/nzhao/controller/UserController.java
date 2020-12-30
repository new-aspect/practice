package com.nzhao.controller;

import com.alibaba.fastjson.JSON;
import com.nzhao.pojo.User;
import com.nzhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nzhao
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/name",method= RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String getUserName(ServletResponse response){
        response.setCharacterEncoding("utf-8");
        List<String> userNameList = userService.getUserName();
        Map map = new HashMap();
        map.put("name",userNameList);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/user/queryAll", method= {RequestMethod.GET,RequestMethod.POST}, produces={"application/json; charset=UTF-8"})
    public String queryAll(){
        List<User> users = userService.queryAll();
        return JSON.toJSONString(users);
    }
}
