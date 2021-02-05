package com.nzhao.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 11507
 */
public class LogoutService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object userSession = req.getSession().getAttribute("USER_SESSION");
        String contextPath = req.getContextPath();
        if (userSession != null){
            req.getSession().removeAttribute("USER_SESSION");
        }
        // 注销以后直接通过url访问页面就跳转
        resp.sendRedirect(contextPath + "/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
