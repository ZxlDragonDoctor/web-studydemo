package com.example.javawebexptest.Servlet.chapter01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="sendRedirect",value={"/send-redirect"})
public class RedirectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        String userAgent = request.getHeader("user-agent");
        // 在请求对象上存储一个属性
        request.setAttribute("param1", "请求作用域属性");
        // 在会话对象上存储一个属性
        HttpSession session = request.getSession();
        session.setAttribute("param2", "会话作用域属性");
        if((userAgent!=null)&&(userAgent.indexOf("Chrome")!=-1)){
            response.sendRedirect("/zxc/chapter01/welcome.jsp");
        }else{
            response.sendRedirect("https://www.baidu.com/");
        }
    }
}
