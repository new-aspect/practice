package com.nzhao.dao.impl;

import com.nzhao.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl的save方式运行起来了");
    }
}
