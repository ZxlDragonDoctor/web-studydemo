package com.example.javawebexptest.Servlet.chapter01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="loginServlet",value={"/user-login"})
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;
        if("admin".equals(username)&& "123456".equals(password)){
            request.setAttribute("username",username);
            rd = request.getRequestDispatcher("/chapter01/welcome.jsp");
        }else{
            rd = request.getRequestDispatcher("/chapter01/error.jsp");
        }
        rd.forward(request,response);
    }
}


