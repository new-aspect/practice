package com.nzhao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nzhao
 */
public class LoginServlet extends HttpServlet {


    /**
     * 这里粗心，使用protected方式修饰doGet和doPost
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("username = " + req.getParameter("username"));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 我在这里居然写了一个duPut，真是不明所以为什么犯这样的错误
        this.doGet(req, resp);
    }
}
