package com.example.javawebexptest.DAO;

import com.example.javawebexptest.eneity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends Dao{
    // 按id查询商品方法
    public Product findProductById (int id) throws SQLException;
    // 查询所有商品方法
    public List<Product> findAllProduct ()throws SQLException;
    //添加商品方法
    public int addProduct (Product product) throws SQLException;
    public boolean deleteProduct(int id) throws SQLException;
}
