package com.nzhao.service.user;

import com.nzhao.pojo.User;

/**
 * @author 11507
 */
public interface UserService {
    /**
     * 根据用户名和密码查询用户是否存在
     * @return 用户
     */
    public User login(String username, String password);

    public boolean updatePwd(Integer id, String password);


}
