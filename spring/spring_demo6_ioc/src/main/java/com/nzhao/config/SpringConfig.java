package com.nzhao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.net.DatagramSocket;

@Configuration
@PropertySource("classpath:jdbc.properties")//引入jdbc的配置文件
public class SpringConfig {

    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    //设置数据源Druid并返回
    @Bean(name = "dataSource")
    DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    //这是方法一，用this.getDataSource调用数据源，但是这样又耦合了，所以弃用
//    @Bean(name = "jdbcTemplate")
//    JdbcTemplate getJdbcTemplate(){
//        return new JdbcTemplate(this.getDataSource());
//    }

    //这是方法二：让Spring帮我们注入
    @Bean(name = "jdbcTmeplate")
    JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
