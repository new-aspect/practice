package com.nzhao.service;

import com.nzhao.pojo.User;

import java.util.List;

/**
 * @author nzhao
 */
public interface UserService {

    /**
     * @return user
     */
    public List<String> getUserName();

    List<User> queryAll();

    void addUser(User user);
}
