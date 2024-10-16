package com.example.brandlist.servlet;

import com.example.brandlist.entity.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/deleteBrand/*")
public class DeleteBrandServlet extends HttpServlet {
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo != null && pathInfo.length() > 1) {
            String idStr = pathInfo.substring(1); // 获取ID
            int id = Integer.parseInt(idStr);

            List<Brand> brands = (List<Brand>) req.getServletContext().getAttribute("brands");
            if (brands != null) {
                brands.removeIf(brand -> brand.getId() == id); // 根据ID删除品牌
                req.getServletContext().setAttribute("brands", brands);
                resp.setStatus(HttpServletResponse.SC_OK); // 返回200状态
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 返回404状态
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 返回400状态
        }
    }
}
