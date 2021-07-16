package com.nzhao.dao;

import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookMappingTest {

    @Test
    public void queryAllBookTest(){
        // 通过获取bookService对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        // 操作BookService对象
        List<Books> books = bookService.queryAllBook();
        System.out.println(books.toString());
    }

    @Test
    public void addBookTest(){
        // 通过获取bookService对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        // 操作BookService对象
        Books books = new Books();
        books.setBookID(6);
        books.setBookName("学会放松");
        books.setBookCounts(10);
        books.setDetail("从放松到焦虑");
        int i = bookService.addBook(books);
        System.out.println(i);
    }

    @Test
    public void updateBookTest(){
        // 通过获取bookService对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        // 操作BookService对象
        Books books = new Books();
        books.setBookID(6);
        books.setBookName("学会放松");
        books.setBookCounts(5);
        books.setDetail("从放松到焦虑");
        int i = bookService.updateBook(books);
        System.out.println(i);
    }

    @Test
    public void queryBookByIdTest(){
        // 通过获取bookService对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        // 操作BookService对象
        Books books = bookService.queryBookById(6);
        System.out.println(books);
    }

    @Test
    public void deleteBookByIdTest(){
        // 通过获取bookService对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        // 操作BookService对象
        int i = bookService.deleteBookById(6);
        System.out.println(i);
    }
}
