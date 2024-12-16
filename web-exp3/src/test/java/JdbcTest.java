import com.zxl.webexp3.webexp3.Dao.impl.ProductDaoImpl;
import com.zxl.webexp3.webexp3.eneity.Categories;
import com.zxl.webexp3.webexp3.eneity.Products;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcTest {
    @Test
    public void testJdbc() throws SQLException {
        Products product = null;
        ProductDaoImpl dao = new ProductDaoImpl();
        ArrayList<Products> productList = new ArrayList<Products>();
        String sql = "SELECT * FROM product WHERE category = ?";
        int cate_id = 0;
        Categories cat = null;
        try {
            Connection connection = dao.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "1");
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
