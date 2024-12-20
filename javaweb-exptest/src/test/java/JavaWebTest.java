import com.example.javawebexptest.eneity.Student;
import org.junit.jupiter.api.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class JavaWebTest {
    public static void main(String[] args) throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver); // 加载驱动程序
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        String username = "root";
        String password = "zxl123";
        String dburl = "jdbc:mysql://127.0.0.1:3306/elearning"
                + "?useSSL=false&serverTimezone=UTC";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dburl, username, password);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Student> studentList = new ArrayList<Student>();
        String sql = "SELECT * FROM students";
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet result = pstmt.executeQuery();
        ) {
            while (result.next()) {
                Student student = new Student();
                student.setStudId(result.getInt("stud_id"));
                student.setName(result.getString("name"));
                student.setGender(result.getString("gender"));
                student.setBirthday(result.getDate("birthday").toLocalDate());
                student.setPhone(result.getString("phone"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(studentList);
    }

    @Test
    public  void TestJDNI() throws SQLException{
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource =
                    (DataSource)context.lookup("java:comp/env/jdbc/elearningDS");
        }catch(NamingException ne){
            System.out.println("Exception:"+ne);
        }

        Connection conn = null;
        try {
            conn = dataSource != null ? dataSource.getConnection() : null;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Student> studentList = new ArrayList<Student>();
        String sql = "SELECT * FROM students";
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet result = pstmt.executeQuery();
        ) {
            while (result.next()) {
                Student student = new Student();
                student.setStudId(result.getInt("stud_id"));
                student.setName(result.getString("name"));
                student.setGender(result.getString("gender"));
                student.setBirthday(result.getDate("birthday").toLocalDate());
                student.setPhone(result.getString("phone"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(studentList);
    }
}
