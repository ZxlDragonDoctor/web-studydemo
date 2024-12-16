package com.zxl.webexp3.webexp3.Dao;



import com.zxl.webexp3.webexp3.eneity.Categories;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends Dao {

    public Categories findCategoryById(int id) throws SQLException;
    public List<Categories> findAllCategories() throws SQLException;

}
