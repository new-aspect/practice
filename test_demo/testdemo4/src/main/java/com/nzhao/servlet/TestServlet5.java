package com.nzhao.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author 11507
 */
public class TestServlet5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获取下载文件的路径
//        String realPath = this.getServletContext().getRealPath("/1.png");
        String realPath = "D:\\Drawer\\IdeaProjects\\github\\practice\\test_demo\\testdemo4\\out\\artifacts\\testdemo4_war_exploded\\WEB-INF\\classes\\1.png";
        System.out.println("下载文件路径 " + realPath);
        //  下载文件的名称
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //  设置浏览器支持
        resp.setHeader("Content-disposition","attachment;filename"+ URLEncoder.encode(filename));
        //  获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //  创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //  获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //  将FileOutputStream对象写入buffer缓冲区, 使用OutputStream将缓冲区的数据输出到客户端
        while ((len = fileInputStream.read(buffer)) > 0){
            outputStream.write(buffer, 0, len);
        }
        //  关闭
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
