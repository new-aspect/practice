package com.nzhao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取前端参数

        //判断前端参数method的方法是什么，根据不同的方法返回不同的参数
        String method = req.getParameter("method");
        if(method.equals("add")){
            req.setAttribute("msg","调用了add方法");
        }
        if(method.equals("delect")){
            req.setAttribute("msg","调用了delete方法");
        }

        //2. 调用业务方法

        //3. 视图转发或者重定向
        //方式一：转发
        //req.getRequestDispatcher("/WEB-INF/test.jsp").forward(req,resp);

        //方式二：重定向,暂时没有想到怎们用重定向传参，现在倒是可以使用转发的方式传参
        resp.sendRedirect("test2.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
