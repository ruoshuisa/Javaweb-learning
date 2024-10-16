package com.example.class04cookiesession.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookieDemo02")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取Cookie 数组
        Cookie[] cookies = req.getCookies();
        //2.遍历数组
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)) {
                System.out.println(name+":"+cookie.getValue());
                break;
            }
        }
    }
}
