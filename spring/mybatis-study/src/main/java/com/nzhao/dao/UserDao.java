package com.nzhao.dao;

import com.nzhao.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> getUserList();

    public int addUser(User user);
}
