package top.soft.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo04")
public class RequestDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);

        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("hobby"+hobby);
        }

        System.out.println("======================");
        System.out.println("获取所有请求的参数名称");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println("参数名称"+name);
            String value = req.getParameter(name);
            System.out.println("参数值"+value);
        }


        System.out.println("======================");
        System.out.println("获取所有请求的参数名称");
        Map<String,String[]> parameterMap = req.getParameterMap();

        Set<String> keySet = parameterMap.keySet();
        for (String name:keySet){
            System.out.println("参数名称"+name);
            String[] values = parameterMap.get(name);
            for (String value:values){
                System.out.println(value);
            }
        }
    }
}
