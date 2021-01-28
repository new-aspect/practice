package com.nzhao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 11507
 */
@WebServlet("/sessiondemo1")
public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到session
        HttpSession session = req.getSession();

        // 可以往session里面存一些东西
        session.setAttribute("name", "zhangsan");

        // 获取session的id
        String id = session.getId();
        System.out.println("-- session.getId() = " + id);

        if (session.isNew()) {
            resp.getWriter().write("新的session创建成功");
        } else {
            resp.getWriter().write("这个session已经存在");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
