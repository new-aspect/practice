package com.nzhao.service.user;

import com.nzhao.dao.BaseDao;
import com.nzhao.dao.user.UserDao;
import com.nzhao.dao.user.UserDaoImpl;
import com.nzhao.pojo.User;
import org.junit.Test;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            // 从业务层调用dao层
            user = userDao.getLoginUser(connection, userCode, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.release(connection, null, null);
        }
        return user;
    }

    // 使用单元测试
    @Test
    public void test(){
        UserService userService = new UserServiceImpl();
        User user = userService.login("admin", "1234567");
        System.out.println(user);
    }
}
