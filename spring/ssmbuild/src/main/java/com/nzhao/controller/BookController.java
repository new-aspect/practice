package com.nzhao.controller;

import com.nzhao.service.BookService;
import com.nzhao.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/allBook")
    public String allBook(){
        return "allBook";
    }
}
