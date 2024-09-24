package com.example.class03response.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置响应码
        resp.setStatus(302);
//      2.设置响应头
     //   resp.setHeader("location", "/responseDemo02");
        //3.设置编码
        resp.setContentType("text/html;charset=UTF-8");
        //4.设置响应结束
        resp.getWriter().println("你好 ResponseDemo01");
    }
}
