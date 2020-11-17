package com.nzhao.service.impl;

import com.nzhao.dao.BookMapping;
import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service()
public class BookServiceImpl implements BookService {

    //service层调用dao层
    @Autowired
    private BookMapping bookMapping;

    //写setter方法，让Spring管理bookMapping方法
    public void setBookMapping(BookMapping bookMapping) {
        this.bookMapping = bookMapping;
    }

    @Override
    public int addBook(Books books) {
        return bookMapping.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapping.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapping.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapping.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapping.queryAllBook();
    }
}
