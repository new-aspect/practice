package com.nzhao.service;

import com.nzhao.dao.BaseDao;
import com.nzhao.dao.user.UserDao;
import com.nzhao.dao.user.UserDaoImpl;
import com.nzhao.pojo.User;

import java.io.File;

public class test8 {
    public static void main(String[] args) {
        File directory = new File("");//设定为当前文件夹
        System.out.println(directory.getAbsolutePath());
        UserDao userDao = new UserDaoImpl();
        User admin = userDao.getLoginUser(BaseDao.getConnection(), "admin");

        System.out.println(admin.toString());
    }
}
