package com.example.class06filterlistener.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private final List<String> list = new ArrayList<>();

    private final String methodName = "getParameter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

           try {
           ServletContext servletContext = filterConfig.getServletContext();
           String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
           InputStreamReader isr = new InputStreamReader(new FileInputStream(realPath), StandardCharsets.UTF_8);
           BufferedReader br = new BufferedReader(isr);
           String line;
           while ((line = br.readLine()) != null) {
               list.add(line);
           }
       }catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        ServletRequest proxyReq = (ServletRequest)  Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodName.equals(method.getName())) {
                    String value = (String) method.invoke(servletRequest, args);
                    if (value != null) {
                        for (String s : list) {
                            if (value.contains(s)) {
                                value = value.replace(s, "****");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest, args);
            }
            });
        filterChain.doFilter(proxyReq, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
