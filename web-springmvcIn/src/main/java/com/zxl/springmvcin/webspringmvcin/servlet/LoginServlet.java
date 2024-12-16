package com.zxl.springmvcin.webspringmvcin.servlet;

import com.zxl.springmvcin.webspringmvcin.pojo.Product;
import com.zxl.springmvcin.webspringmvcin.pojo.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "homeServlet",value = "/home")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("执行servlet");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        String dispatchUrl = null;
        if ("admin".equals(username) && "123456".equals(password)) {
            request.getSession().setAttribute("user", user);
            List<Product> productList = new ArrayList<Product>();
            productList.add(new Product(101, "Lenovo笔记本电脑", "Lenovo", new BigDecimal("4500.00")));
            productList.add(new Product(102, "华为手机", "华为", new BigDecimal("2500.00")));
            request.setAttribute("productList", productList);
            dispatchUrl = "main.jsp";
        } else {
            dispatchUrl = "error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
        rd.forward(request, response);
    }
}