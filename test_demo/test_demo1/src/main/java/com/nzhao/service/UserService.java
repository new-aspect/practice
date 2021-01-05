package com.nzhao.service;

import com.nzhao.pojo.User;

import java.util.List;

/**
 * @author nzhao
 */
public interface UserService {

    /**
     * 返回用户名
     * @return user
     */
    public List<String> getUserName();

    /**
     * 返回查询所有
     * @return
     */
    List<User> queryAll();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
}
