package com.nzhao;

import com.nzhao.config.SpringConfig;
import com.nzhao.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        //通过Spring获取JdbcTemplate
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        //使用JdbcTemplate对象操作数据库
        //查找数据
        List userList = jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper(User.class));
        System.out.println(userList);

        //增加数据
        int insert = jdbcTemplate.update("INSERT INTO user (user_id,user_name,user_address)VALUE(?,?,?)", "6", "王伟", "天津");
        System.out.println(insert);

        //删除数据
        int delete = jdbcTemplate.update("DELETE FROM user WHERE user_id = ?", 6);
        System.out.println(delete);

        //更改数据
        int update = jdbcTemplate.update("UPDATE user SET user_name= ? ,user_address= ? WHERE user_id= ?", "老四", "上海", "3");
        System.out.println(update);

    }
}