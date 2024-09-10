package top.soft.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo02")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // 获取请求数据
        //1.遍历所有请求头数据
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();

            String value = req.getHeader(name);
            System.out.println(name+":"+value);
        }

        //2.根据名称获取请求头的值
        String header = req.getHeader("user-agent");
        if (header.contains("Edg")){
            System.out.println("Edge 浏览器");
        } else if (header.contains("Chrome")) {
            System.out.println("Chrome 浏览器");
        }
    }
}
