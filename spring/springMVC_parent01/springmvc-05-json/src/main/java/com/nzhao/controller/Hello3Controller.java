package com.nzhao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nzhao.dao.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Hello3Controller {

    @RequestMapping("/hello3")
    public String hello3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<>();

        //测试返回集合类型
        User user1 = new User(1, "工具人", 13);
        User user2 = new User(2, "工具人", 13);
        User user3 = new User(3, "工具人", 13);
        User user4 = new User(4, "工具人", 13);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        //将集合对象转换为json
        String json = mapper.writeValueAsString(userList);
        return json;
    }
}
