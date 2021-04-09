package com.nzhao.dao.user;

import com.nzhao.dao.BaseDao;
import com.nzhao.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 11507
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode) {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM `smbms_user` WHERE userCode = ? ";
        Object[] params = {userCode};
        PreparedStatement preparedStatement = null;
        try {
            BaseDao.excute(connection, sql, params, resultSet, preparedStatement);
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setCreateBy(resultSet.getInt("createBy"));
                user.setCreationDate(resultSet.getDate("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getDate("Date"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findUser() {
        return null;
    }
}
