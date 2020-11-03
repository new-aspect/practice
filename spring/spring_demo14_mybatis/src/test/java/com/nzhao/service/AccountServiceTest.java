package com.nzhao.service;

import com.nzhao.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class AccountServiceTest {

    @Autowired
    AccountService accountService;


    @Test
    public void findAllTest(){
        System.out.println(accountService.findAll());
    }

    @Test
    public void AddTest(){
        accountService. add(new Account(5,"卫宫",400.0));
    }

}
