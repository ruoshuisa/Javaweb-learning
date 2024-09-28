package com.example.bookonline.servlet;

import com.example.bookonline.dao.impl.UserDaoImpl;
import com.example.bookonline.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserDaoImpl userDao = new UserDaoImpl();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String avatar = req.getParameter("avatar");
        String address = req.getParameter("address");

        if (userDao.isUserExists(account)) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('该账户已存在，请更换账户注册');location.href='/register';</script>");
            return;
        }

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setAvatar(avatar);
        user.setAddress(address);

        int result = userDao.insertUser(user);

        if (result > 0) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('注册成功');location.href='/';</script>");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('注册失败');location.href='/register';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.html").forward(req, resp);
    }
}