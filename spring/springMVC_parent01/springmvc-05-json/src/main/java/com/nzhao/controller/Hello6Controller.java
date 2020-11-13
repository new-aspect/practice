package com.nzhao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nzhao.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Hello6Controller {

    @RequestMapping("/hello6")
    public String hello5() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtil.getJson(date, "yyyy-MM-dd HH:mm:ss");
        return json;
    }
}
