package com.nzhao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 11507
 */
public class TestServlet5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/pictures/1.png");
        System.out.println("下载文件路径 " + realPath);
        //  下载文件的名称
        //  设置浏览器支持
        //  获取下载文件的输入流
        //  创建缓冲区
        //  获取OutputStream对象
        //  将FileOutputStream对象写入buffer缓冲区
        //  使用OutputStream将缓冲区的数据输出到客户端
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
