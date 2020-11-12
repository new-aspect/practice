package com.nzhao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Hello4Controller {

    @RequestMapping("/hello4")
    public String hello4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //创建时间Date
        Date date = new Date();

        //将Date对象转换json
        String json = mapper.writeValueAsString(date);
        return json;
    }
}
