package com.nzhao.servlet.user;

import com.nzhao.pojo.User;
import com.nzhao.service.user.UserService;
import com.nzhao.service.user.UserServiceImpl;
import com.nzhao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nzhao
 */
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    /**
     * 这里粗心，使用protected方式修饰doGet和doPost
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取页面的UserCode和UserPassword
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        // 和数据库对比UserCode和UserPassword是否一致，如果一致，返回有login，如果不一致，返回空
        User user = userService.login(userCode, userPassword);

        if (user != null) {
            // 查到有这个人，将这个人的信息放到session
            req.getSession().setAttribute(Constants.User_Session,user);
            // 登录成功，跳转到主页
            resp.sendRedirect("jsp/frame.jsp");
        } else {
            // 没有查到这个人，登录失败，转发到登录页面，顺带提示用户名或密码错误
            req.getSession().setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 我在这里居然写了一个duPut，真是不明所以为什么犯这样的错误
        this.doGet(req, resp);
    }
}
