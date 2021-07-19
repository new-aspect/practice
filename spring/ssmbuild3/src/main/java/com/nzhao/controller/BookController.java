package com.nzhao.controller;

import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String allBook(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        // 因为在spring-mvx.xml中配置的试图解析器会添加前缀/WEB-INF/jsp/和后缀.jsp
        // 所以最后访问/WEB-INF/jsp/allBook.jsp页面
        return "allBook";
    }

    // 跳转到addBook.jsp页面
    @RequestMapping("/toAddBookPage")
    public String toAddBookPage() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(HttpServletRequest request) {
        Books books = new Books();
        books.setBookID(Integer.parseInt((String)request.getParameter("bookID")));
        books.setBookName((String) request.getParameter("bookName"));
        books.setBookCounts(Integer.parseInt((String) request.getParameter("bookCounts")));
        books.setDetail((String) request.getParameter("detail"));
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBookPage")
    public String toUpdateBookPage(int bookID, Model model){
        Books books = bookService.queryBookById(bookID);
        model.addAttribute("books",books);
        return "editBook";
    }

    @RequestMapping("/editBook")
    public String editBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
}
