package com.example.javawebexptest.Servlet.chapter02;

import com.example.javawebexptest.DAO.ProductDao;
import com.example.javawebexptest.DAO.impl.ProductDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteProductServlet", value = "/delete-product")
public class DeleteProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doDelete(request, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao dao = new ProductDaoImpl();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String message = null;
        try {
            boolean success = dao.deleteProduct(id);
            if (success) {
                message = "<li>成功删除一条记录！</li>";
            } else {
                message = "<li>删除记录错误！</li>";
            }
        } catch (Exception e) {
            System.out.println(e);
            message = "<li>删除记录错误！</li>" + e;
        }
        message = "<li>" + message + "</li>";
        request.getSession().setAttribute("result", message);
        response.sendRedirect("/zxc/chapter02/message-product.jsp");
    }
}