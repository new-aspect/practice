package com.nzhao;

import com.nzhao.mapper.UserMapper;
import com.nzhao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }
}
