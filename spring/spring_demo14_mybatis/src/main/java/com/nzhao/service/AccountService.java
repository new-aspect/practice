package com.nzhao.service;

import com.nzhao.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    void add(Account account);

    /**
     * 根据id名称删除一条数据
     */
    void deleteById(Integer id);

    /**
     * 修改一条数据
     */
    void update(Account account);
}
