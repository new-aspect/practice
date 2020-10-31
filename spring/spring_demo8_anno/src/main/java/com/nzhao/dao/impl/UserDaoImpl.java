package com.nzhao.dao.impl;

import com.nzhao.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDaoImpl 已经启动了");
    }
}
