package com.nzhao.dao;


import com.nzhao.pojo.User;
import com.nzhao.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        UserDao userDao = MybatisUtil.getSeqSession().getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        System.out.println(userList);
    }

    @Test
    public void addUserTest(){
        UserDao mapper = MybatisUtil.getSeqSession().getMapper(UserDao.class);
        User user = new User();
        user.setId(4);
        user.setUsername("xiaofei");
        user.setPassword("123456");
        mapper.addUser(user);
    }
}
