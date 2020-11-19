package com.nzhao.controller;

import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


//    @RequestMapping("/toAllPager")
//    public String toAllPager(){
//        return "AllBook";
//    }

    @RequestMapping("/allBook")
    public String allBook(Model model){
        List<Books> booksList = bookService.queryAll();
        model.addAttribute("beforeBooksList",booksList);
        return "allBook";
    }

    @RequestMapping("/toaddPage")
    public String toAddPage(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";//注意这里是重定向
    }
}
