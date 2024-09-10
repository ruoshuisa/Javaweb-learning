
package top.soft.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author ycshang
 * @description: 请求转发
 * @date 2024-09-10 下午4:42
 */
@WebServlet("/requestDemo05")
public class RequestDemo5  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问 requestDemo05");
        req.getRequestDispatcher("/requestDemo06").forward(req,resp);

    }
}
