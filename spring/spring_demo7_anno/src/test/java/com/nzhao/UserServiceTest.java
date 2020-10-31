package com.nzhao;

import com.nzhao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//这里进行Spring整合Junit
@RunWith(SpringJUnit4ClassRunner.class)
//方式一：读取配置的xml文件
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
//方式二：读取配置类用ContextConfiguration
//@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    public void test(){
        userService.save();
    }
}
