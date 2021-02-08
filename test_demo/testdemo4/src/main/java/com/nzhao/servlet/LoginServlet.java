package com.nzhao.servlet;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 11507
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) && "admin".equals(username.trim()) && "123456".equals(password.trim())) {
            System.out.println("-- 登录成功");
            req.getSession().setAttribute("user_session",req.getSession().getId());
            req.getRequestDispatcher("/sys/success.html").forward(req, resp);
        } else {
            System.out.println("-- req = " + req);
            System.out.println("-- req.getRequestDispatcher(\"/fail.html\") = " + req.getRequestDispatcher("/fail.html"));
            req.getRequestDispatcher("fail.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
