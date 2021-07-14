package com.nzhao.service;

import com.nzhao.dao.BookMapping;
import com.nzhao.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookMapping bookMapping;

    // 给BookMapping对象set方法，就可以让Spring托管
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
