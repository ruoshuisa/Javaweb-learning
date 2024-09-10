package top.soft.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       1. 获取请求方式
        String method = req.getMethod();
        System.out.println("请求方式"+method);

//       2. 获取severlet路径
        String servletPath = req.getServletPath();
        System.out.println("获取Serverlet路径"+servletPath);
//        3.获取get请求参数
        String queryString = req.getQueryString();
        System.out.println("Get请求参数"+queryString);
//  4.获取请求uri和url
        String requestURI = req.getRequestURI();
        System.out.println("请求URI"+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("请求URL"+requestURL);


        String protocol = req.getProtocol();
        System.out.println("版本协议"+protocol);

//        6.获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("虚拟目录"+contextPath);



    }
}