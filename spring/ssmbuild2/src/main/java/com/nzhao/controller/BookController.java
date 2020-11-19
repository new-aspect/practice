package com.nzhao.controller;

import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "AllBook";
    }
}
