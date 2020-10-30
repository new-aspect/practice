package com.nzhao.service.impl;

import com.nzhao.dao.UserDao;
import com.nzhao.dao.impl.UserDaoImpl;
import com.nzhao.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    //注意：使用xml的方式注入，必须要写set方式
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }


}
