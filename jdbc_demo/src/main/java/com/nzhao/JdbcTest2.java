package com.nzhao;

import com.nzhao.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 11507
 */
public class JdbcTest2 {

    public static void main(String[] args) throws SQLException {
        Connection connector = JdbcUtils.getConnector();
        //测试事物

        //首先设置事物自动提交关闭
        connector.setAutoCommit(false);

        String sql = "UPDATE `users` SET `name` = 'aimiliya' WHERE `id` = 1;";
        Statement statement = connector.createStatement();
        statement.execute(sql);

        // 设置提交事物
        // connector.commit();

        // 设置事物回滚
        connector.rollback();

        // 关闭连接
        JdbcUtils.release(connector,statement,null);
    }
}
