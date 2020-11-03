package com.nzhao.service.impl;

import com.nzhao.dao.AccountDao;
import com.nzhao.pojo.Account;
import com.nzhao.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void add(Account account) {
        accountDao.add(account);
    }
}
