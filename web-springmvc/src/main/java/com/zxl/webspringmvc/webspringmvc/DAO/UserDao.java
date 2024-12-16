package com.zxl.webspringmvc.webspringmvc.DAO;

import com.zxl.webspringmvc.webspringmvc.entity.User;
import com.zxl.webspringmvc.webspringmvc.tools.DbConnectPool;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserDao {
    public boolean addUser(User user) {
        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?)";
        boolean n = false;
        try (Connection conn = DbConnectPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getUsertype());
            pstmt.setString(5, user.getSex());
            pstmt.setString(6, user.getAddress());
            // 注意：这里缺少了对birthday字段的处理，如果需要插入生日信息，需要添加如下代码：
             pstmt.setDate(7, user.getBirthday());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                n = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}