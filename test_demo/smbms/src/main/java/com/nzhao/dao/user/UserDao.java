package com.nzhao.dao.user;

import com.nzhao.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * 操作User类
 * @author 11507
 */
public interface UserDao {

    /**
     * 通过UserCode查询User
     */
    public User getLoginUser(Connection connection, String userCode);

    /**
     * 查找所有用户
     * @return User类
     */
    public List<User> findUser();

    public User getLoginUser(Connection connection ,String userCode, String password);

    /**
     * 修改密码
     */
    public int updatePwd(Connection connection, Integer id, String password);
}
