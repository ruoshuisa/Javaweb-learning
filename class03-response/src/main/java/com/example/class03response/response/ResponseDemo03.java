package com.example.class03response.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/responseDemo03")

public class ResponseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String type = req.getParameter("type");
    switch (type) {
        case "img":
            getImage(req, resp);
            break;
        case "text":
            getText(req, resp);
            break;
        case "html":
            getHtml(req, resp);
            break;
        case "pdf":
            getPdf(req, resp);
            break;
        default:
            break;
    }
    }

    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("image/png");
    String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath  + "/img/image.png");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();

    }

    private void getText(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/txt;charset=utf-8");
        String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath  + "/text/text.txt");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();
    }

    private void getHtml(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath  + "/HTML/yk.html");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();
    }

    private void getPdf(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/pdf");
        String realPath = req.getServletContext().getRealPath("");
        File file = new File(realPath  + "/PDF/pdf.pdf");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();
    }
}
