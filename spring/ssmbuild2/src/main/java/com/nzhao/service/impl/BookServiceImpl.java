package com.nzhao.service.impl;

import com.nzhao.dao.BookMapping;
import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookMapping bookMapping;

    public void setBookMapping(BookMapping bookMapping) {
        this.bookMapping = bookMapping;
    }

    @Override
    public List<Books> queryAll() {
        return bookMapping.queryAll();
    }

    @Override
    public void addBook(Books books) {
        bookMapping.addBook(books);
    }

    @Override
    public void deleteBookByBookID(int bookID) {
        bookMapping.deleteBookByBookID(bookID);
    }

    @Override
    public void updateBook(Books books) {
        bookMapping.updateBook(books);
    }

    @Override
    public Books queryBookByBookID(int bookID) {
        return bookMapping.queryBookByBookID(bookID);
    }
}
