package com.nzhao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.nzhao"})//扫描com.nzhao下面的包
public class SpringConfig {
}
