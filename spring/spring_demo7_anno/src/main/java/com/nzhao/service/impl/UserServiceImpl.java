package com.nzhao.service.impl;

import com.nzhao.dao.UserDao;
import com.nzhao.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
