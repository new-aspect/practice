package com.nzhao.dao;

import com.nzhao.pojo.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();
}
