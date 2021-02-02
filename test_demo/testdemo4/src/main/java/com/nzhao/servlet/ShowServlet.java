package com.nzhao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这是演示中文乱码的servlet
 * @author 11507
 */
@WebServlet("/show-servlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看系统默认编码方式
        System.out.println("--系统的编码 = "+System.getProperty("file.encoding"));

        /**
         * setContentType的作用是使客户端浏览器区分不同种类的数据，
         * 并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
         *
         * 例如：web浏览器就是通过MIME类型来判断文件是GIF图片，通过MIME类型来处理json字符串。
         * Tomcat的安装目录\conf\web.xml 中就定义了大量MIME类型 ，可以参考。
         * response.setContentType(“text/html; charset=utf-8”); html
         * response.setContentType(“text/plain; charset=utf-8”); 文本
         * response.setContentType(“text/javascript; charset=utf-8”); json数据
         * response.setContentType(“application/xml; charset=utf-8”); xml数据
         */
        resp.setContentType("text/html;charset=UTF-8");

        /**
         * setCharacterEncoding的作用是设置发送到客户端的响应的字符编码（MIME字符集）
         *
         * 使用text/html的字符串调用调用此方法设置setCharacterEncoding("utf-8")
         * 等效于使用setContentType(text/html; charset=UTF-8)
         */
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(new String("你好，这里是Show Servlet".getBytes("utf-8")));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
