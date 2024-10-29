package com.example.class06filterlistener.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class FilterDemo1 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("初始化");
    }

    public void destroy() {
      //  System.out.println(
       //         "销毁"
      //  );
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
       // System.out.println("FilterDemo1 执行");

        filterChain.doFilter(servletRequest,servletResponse);
       // System.out.println("FilterDemo1 资源访问后经过拦截器");
    }
}
