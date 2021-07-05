package com.nzhao.servlet.user;

import com.google.gson.Gson;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (!StringUtils.isNullOrEmpty(method) && method.equals("savepwd")) {
            this.updatePwd(req, resp);
        } else if (!StringUtils.isNullOrEmpty(method) && method.equals("pwdmodify")) {
            this.pwdModify(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从session中获取user
        User user = (User) req.getSession().getAttribute(Constants.User_Session);
        String newpassword = (String) req.getParameter("newpassword");
        if (user != null && !StringUtils.isNullOrEmpty(newpassword)) {
            Integer id = user.getId();
            boolean flag = userService.updatePwd(id, newpassword);
            if (flag) {
                req.getSession().setAttribute("message", "修改密码成功");
                // 密码修改成功，移除当前用户的session
                req.getSession().removeAttribute(Constants.User_Session);
            } else {
                req.getSession().setAttribute("message", "修改密码失败");
            }
        } else {
            req.getSession().setAttribute("message", "修改密码失败，密码或用户不能为空");
        }

        req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
    }

    public void pwdModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldpassword");
        User user = (User) req.getSession().getAttribute(Constants.User_Session);
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNullOrEmpty(oldPassword)) {
            //旧密码输入为空
            map.put("result","error");
        } else if (user == null) {
            //当前用户session过期，请重新登录
            map.put("result","sessionerror");
        } else if(!oldPassword.equals(user.getUserPassword())){
            //旧密码输入不正确
            map.put("result","false");
        } else {
            //旧密码正确
            map.put("result","true");
        }

        // 不要忘了设置为json
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(gson.toJson(map));
    }
}
