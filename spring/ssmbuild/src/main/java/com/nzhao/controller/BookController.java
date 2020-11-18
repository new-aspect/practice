package com.nzhao.controller;

import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import com.nzhao.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    /**
     * 查询书籍的全部信息，转发视图
     * @param model
     * @return
     */
    @RequestMapping("/allBook")
    public String allBook(Model model){
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("list",booksList);
        return "allBook";
    }

    /**
     * 跳转到增加书籍页面
     */
    @RequestMapping("/toAddPaper")
    public String toAddPaper(){
        return "addBook";
    }

    /**
     * 添加书籍的请求
     */
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(" >=  books  = "+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向到@RequestMapping("/allBook")请求
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(int bookID,Model model){
        Books books = bookService.queryBookById(bookID);
        model.addAttribute("beforeBooks",books);
        return "updateBook";
    }

    /**
     * 修改书籍
     */
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    /**
     * 删除书籍
     */
    @RequestMapping("/delectBook")
    public String delectBook(int bookID){
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }

}
