package com.nzhao.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 11507
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String contextPath = request.getContextPath();
        String userSession = "USER_SESSION";
        if(request.getSession().getAttribute(userSession) == null){
            response.sendRedirect(contextPath + "/login.html");
        }

        // 让过滤器继续执行下去
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
