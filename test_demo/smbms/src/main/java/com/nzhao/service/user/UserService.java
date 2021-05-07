package com.nzhao.service.user;

import com.nzhao.pojo.User;

/**
 * @author 11507
 */
public interface UserService {
    /**
     * @return 判断
     */
    public User login(String username, String password);
}
