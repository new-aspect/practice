package com.nzhao.service.user;

import com.nzhao.dao.BaseDao;
import com.nzhao.dao.user.UserDao;
import com.nzhao.dao.user.UserDaoImpl;
import com.nzhao.pojo.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            userDao.getLoginUser(connection,userCode, password);
        } catch (Exception e){

        }

        return null;
    }
}
