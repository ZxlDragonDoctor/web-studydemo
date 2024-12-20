package com.example.javawebexptest.Servlet.chapter01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name="show-time",value={"/showTime"})
public class ShowTimeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Refresh","5");
        PrintWriter out = response.getWriter();
        LocalTime now = LocalTime.now();
        // 将本地时间格式化成字符串
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
        String t = now.format(format);
        out.println("<!DOCTYPE html><html>");
        out.println("<head><title>当前时间</title></head>");
        out.println("<body>");
        out.println("<p>每5秒钟刷新一次页面<p>");
        out.println("<p>现在的时间是："+t+"<p>");
        out.println("</body>");
        out.println("</html>");
    }
}
