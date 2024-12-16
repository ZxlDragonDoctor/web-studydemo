package com.zxl.webexp3.webexp3.Dao.impl;


import com.zxl.webexp3.webexp3.Dao.ProductDao;
import com.zxl.webexp3.webexp3.eneity.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Categories findCategoryById(int id) throws SQLException {
        String sql = "SELECT * FROM categories WHERE cate_id = ?";
        Categories category = null;
        boolean n = false;
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    category = new Categories(rst.getInt("cate_id"), rst.getString("cate_name"));
                }
            }
        } catch (SQLException se) {
            return null;
        }
        return category;
    }

    @Override
    public List<Categories> findAllCategories() throws SQLException {
        Categories category = null;
        ArrayList<Categories> categoryList = new ArrayList<Categories>();
        String sql = "SELECT cate_id, cate_name FROM categories";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                category = new Categories(rst.getInt("cate_id"), rst.getString("cate_name"));
                categoryList.add(category);
            }
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
