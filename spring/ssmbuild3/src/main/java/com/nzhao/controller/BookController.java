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
    // controller 层调用 service层，这里的注解是Spring注入service对象
    @Autowired
    private BookService bookService;

    // 查询全部的数据并且返回到页面
    @RequestMapping("/allBook")
    // 参数Model是由Spring自动注入
    public String allBook(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        // 因为在spring-mvx.xml中配置的试图解析器会添加前缀/WEB-INF/jsp/和后缀.jsp
        // 所以最后访问/WEB-INF/jsp/allBook.jsp页面
        return "allBook";
    }
}
