package com.nzhao.service.impl;

import com.nzhao.dao.UserMapping;
import com.nzhao.pojo.User;
import com.nzhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapping userMapping;

    @Override
    public List<String> getUserName() {
        return userMapping.getUserName();
    }

    @Override
    public List<User> queryAll() {
        return userMapping.queryAll();
    }
}
