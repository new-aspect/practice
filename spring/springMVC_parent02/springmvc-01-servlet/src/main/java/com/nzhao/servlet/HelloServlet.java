package com.nzhao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接受前端发过来的请求

        //You should only use this method when you are sure the parameter has only one value. If the parameter might have more than one value, use getParameterValues(java.lang.String).
        String method = req.getParameter("method");
        if (method.equals("add")) {
            req.getSession().setAttribute("msg", "访问了add方法");
        }
        if (method.equals("delete")){
            req.getSession().setAttribute("msg","访问了delete方法");
        }

        //2. 处理发过来的请求
        //3. 视图转发或者重定向
        req.getRequestDispatcher("/WEB-INF/test.jsp").forward(req,resp);

        //补充，转发使用request.getRequestDispatcher(path).forward(request,response)
        //     重定向用resp.encodeRedirectURL()
        //request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Post调用Get，方便程序复用
        doGet(req, resp);
    }
}
