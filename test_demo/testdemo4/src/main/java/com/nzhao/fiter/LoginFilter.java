package com.nzhao.fiter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现一个假的登录servlet
 * @author 11507
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String username = (String) request.getAttribute("username");
        if (StringUtils.isNotBlank(username)) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/login.html").forward(request, response);
            // 坑，没有添加下面这句，导致过滤器不继续向下执行
            chain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
