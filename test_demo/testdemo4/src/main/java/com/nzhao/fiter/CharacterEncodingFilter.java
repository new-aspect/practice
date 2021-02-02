package com.nzhao.fiter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符过滤器，注意要实现servlet包的Filter
 * @author 11507
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--CharterEncodingFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");

        //执行完成以后，一定让这个链继续往下走，
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("--CharterEncodingFilter 销毁");
    }
}
