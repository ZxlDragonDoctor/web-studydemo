package com.example.javawebexptest.Servlet.chapter02;

import com.example.javawebexptest.DAO.impl.ProductDaoImpl;
import com.example.javawebexptest.eneity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "findProductServlet",value = "/find-product")
public class FindProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDaoImpl dao = new ProductDaoImpl();
        List<Product> productList ;
        try {
           productList = dao.findAllProduct();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       if(!productList.isEmpty()){
           req.getSession().setAttribute("productList",productList);
       }
        resp.sendRedirect("/zxc/chapter02/show-products.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDaoImpl dao = new ProductDaoImpl();
        String id = req.getParameter("id");
        Product product ;
        try {
            product = dao.findProductById(Integer.parseInt(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getSession().setAttribute("product",product);
        resp.sendRedirect("/zxc/chapter02/show-product.jsp");
    }
}
