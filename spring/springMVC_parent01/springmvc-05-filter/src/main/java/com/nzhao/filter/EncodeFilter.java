package com.nzhao.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 解决POST编码问题
 */
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Encode过滤器运行doFilter方法了");
        request.setCharacterEncoding("utf-8");

        //执行完成以后，一定让这个链继续往下走，
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
