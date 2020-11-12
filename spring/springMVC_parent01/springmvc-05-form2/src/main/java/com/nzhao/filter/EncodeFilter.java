package com.nzhao.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter运行了");
        request.setCharacterEncoding("utf-8");

        //不要忘记继续拦截,执行完成以后，一定让这个链继续往下走，
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
