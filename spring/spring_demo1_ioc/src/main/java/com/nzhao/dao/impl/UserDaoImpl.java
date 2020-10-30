package com.nzhao.dao.impl;

import com.nzhao.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {


    @Override
    public void save() {
        System.out.println("UserDaoImpl 中的save 运行了");
    }
}
