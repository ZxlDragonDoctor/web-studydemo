package com.example.javawebexptest.Servlet.chapter02;

import com.example.javawebexptest.DAO.ProductDao;
import com.example.javawebexptest.DAO.impl.ProductDaoImpl;
import com.example.javawebexptest.eneity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addProductServlet" , value = "/add-product" )
public class AddProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao dao = new ProductDaoImpl();
        Product product = null;
        String message = null;
        try{
            product = new Product(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name"),
                    request.getParameter("brand"),
                    Double.parseDouble(request.getParameter("price")));

            int success = dao.addProduct(product);
            if(success==1){
                message = "<li>成功插入一条记录！</li>";
            }else{
                message = "<li>插入记录错误！</li>";
            }
        }catch(Exception e){
            System.out.println(e);
            message = "<li>插入记录错误！</li>" + e;
        }
        request.getSession().setAttribute("result", message);
        RequestDispatcher rd =
                getServletContext().getRequestDispatcher("/chapter02/message-product.jsp");
        rd.forward (request,response);
    }
}
