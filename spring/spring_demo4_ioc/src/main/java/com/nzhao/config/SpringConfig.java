package com.nzhao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration//声明Spring
@PropertySource(value = "classpath:jdbc.properties")//@PropertySource能加载properties文件
public class SpringConfig {

    //从配置文件jdbc.properties取出设置数据源的参数
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;


    @Bean(name = "dataSource")//设置数据源Druid
    public DataSource getDataSource(){
        //创建数据源
        DruidDataSource dataSource = new DruidDataSource();
        //设置数据源连接参数
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //返回数据源
        return dataSource;
    }
}
