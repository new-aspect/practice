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
}
