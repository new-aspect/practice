package com.nzhao.dao;

import com.nzhao.pojo.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查找所有
     * @return
     */
    List<Account> findAll();

    /**
     * 添加一条数据
     */
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
