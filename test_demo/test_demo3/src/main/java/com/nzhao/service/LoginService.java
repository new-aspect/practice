package com.nzhao.service;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 11507
 */
public class LoginService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if (StringUtils.isNotBlank(username) && "admin".equals(username)) {
            // 登录成功，将登录信息放到session中
            req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
            System.out.println("-- 登录成功");
            resp.sendRedirect("/example/sys/success.html");
        } else {
            resp.sendRedirect("/example/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
