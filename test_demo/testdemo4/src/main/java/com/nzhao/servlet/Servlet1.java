package com.nzhao.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试ServletContext共享Servlet数据，需要两个Servlet，
 * 一个是Servlet1，一个是Servlet2
 * @author nzhao
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        req.setCharacterEncoding("UTF-8");

        // 没有乱码的代码
        String name = new String("李四".getBytes("UTF-8"));

        // 乱码的代码
//        String name = "李四";

        // 将一个数据放入ServletContext
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("name",name);

        System.out.println("Servlet1 name = " + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
