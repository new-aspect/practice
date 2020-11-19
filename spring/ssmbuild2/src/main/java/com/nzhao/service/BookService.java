package com.nzhao.service;

import com.nzhao.pojo.Books;

import java.util.List;

public interface BookService {
    /**
     * 查询所有
     */
    List<Books> queryAll();

    /**
     * 增加一个书籍
     */
    void addBook(Books books);

    /**
     * 根据id删除书籍
     */
    void deleteBookByBookID(int bookID);

    /**
     * 编辑书籍
     */
    void updateBook(Books books);

    /**
     * 根据id查询书籍
     */
    Books queryBookByBookID(int bookID);
}
