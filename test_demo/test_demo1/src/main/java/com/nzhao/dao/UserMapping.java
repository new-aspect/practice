package com.nzhao.dao;

import com.nzhao.pojo.User;

import java.util.List;

/**
 * @author nzhao
 */
public interface UserMapping {

    /**
     * 返回用户名
     * @return
     */
    List<String> getUserName();

    /**
     * 查询所用
     * @return
     */
    List<User> queryAll();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
}
