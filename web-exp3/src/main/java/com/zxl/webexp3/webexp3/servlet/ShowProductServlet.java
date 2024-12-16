package com.zxl.webexp3.webexp3.servlet;


import com.zxl.webexp3.webexp3.Dao.impl.ProductDaoImpl;
import com.zxl.webexp3.webexp3.eneity.Categories;
import com.zxl.webexp3.webexp3.eneity.Products;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "showProductServlet",value = "/show-product")
public class ShowProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Products product = null;
        ProductDaoImpl dao = new ProductDaoImpl();
        ArrayList<Products> productList = new ArrayList<Products>();
        String id = request.getParameter("cate_id");
        String sql = "SELECT * FROM product WHERE category = ?";
        int cate_id = 0;
        Categories cat = null;
        try {
            Connection connection = dao.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                cate_id = rst.getInt("category");
                cat = dao.findCategoryById(cate_id);
                product = new Products(
                    rst.getInt("id"),
                    rst.getString("pname"),
                    rst.getInt("category"),
                    rst.getString("image"),
                    rst.getString("brand"),
                    rst.getDouble("price"));
                productList.add(product);
            }
            System.out.println(productList);
            if (!productList.isEmpty()) {
                request.getSession().setAttribute("productList", productList);
                request.getSession().setAttribute("cat", cat);
                response.sendRedirect(request.getContextPath() + "/showProduct.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}