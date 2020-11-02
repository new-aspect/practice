package com.nzhao;

import com.nzhao.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class serviceTest {

    @Autowired
    AccountService accountService;

    @Test
    public void test(){
        System.out.println(accountService.findAll());
    }
}
