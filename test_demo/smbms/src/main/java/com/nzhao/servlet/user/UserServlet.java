package com.nzhao.servlet.user;

import com.mysql.jdbc.StringUtils;
import com.nzhao.pojo.User;
import com.nzhao.service.user.UserService;
import com.nzhao.service.user.UserServiceImpl;
import com.nzhao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从session中获取user
        User user = (User) req.getSession().getAttribute(Constants.User_Session);
        String newpassword = (String) req.getParameter("newpassword");
        if(user != null && !StringUtils.isNullOrEmpty(newpassword)){
            Integer id = user.getId();
            boolean flag = userService.updatePwd(id,newpassword);
            if(flag){
                req.getSession().setAttribute("message","修改密码成功");
                // 密码修改成功，移除当前用户的session
                req.getSession().removeAttribute(Constants.User_Session);
            } else {
                req.getSession().setAttribute("message","修改密码失败");
            }
        } else{
            req.getSession().setAttribute("message","修改密码失败，密码或用户不能为空");
        }

        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
