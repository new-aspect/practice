package com.nzhao.dao;

import com.nzhao.pojo.User;

import java.util.List;

/**
 * @author nzhao
 */
public interface UserMapping {

    List<String> getUserName();

    List<User> queryAll();

    void addUser(User user);
}
