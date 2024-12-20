package com.example.javawebexptest.Servlet.chapter02;



import com.example.javawebexptest.eneity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "findStudentServlet" ,value = "/find-student-servlet")
public class FindStudentServlet extends HttpServlet {
    //TODO:1.不使用数据源
//    public void init() {
//        String driver = "com.mysql.cj.jdbc.Driver";
//        try {
//            Class.forName(driver); // 加载驱动程序
//        } catch (ClassNotFoundException e) {
//            System.out.println(e);
    //            getServletContext().log("驱动程序类找不到！");
//        }
//    }
    //TODO：2.使用JDNI配置的数据源
    DataSource dataSource;
    public void init() {
        try {
            Context context = new InitialContext();
            dataSource =
                    (DataSource)context.lookup("java:comp/env/jdbc/elearningDS");
        }catch(NamingException ne){
            System.out.println("Exception:"+ne);
        }
    }
    // doGet()和doPost()方法中的Connection对象通过DataSource的getConnetion()方法获得



    public Connection getConnection() throws SQLException {
//        String username = "root";
//        String password = "zxl123";
//        String dburl = "jdbc:mysql://127.0.0.1:3306/elearning"
//                + "?useSSL=false&serverTimezone=UTC";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("进入到get方法");
        ArrayList<Student> studentList = new ArrayList<Student>();
        String sql = "SELECT * FROM students";
        try (
                Connection conn = getConnection();
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
        if (!studentList.isEmpty()) {
            request.getSession().setAttribute("studentList", studentList);
            response.sendRedirect("/zxc/chapter02/show-students.jsp");
        } else {
            response.sendRedirect("/zxc/chapter02/error.jsp");
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("进入到post方法");
        String studentid = request.getParameter("stud_id");
        String sql = "SELECT * FROM students WHERE stud_id = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, studentid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                Student student = new Student();
                student.setStudId(rst.getInt("stud_id"));
                student.setName(rst.getString("name"));
                student.setGender(rst.getString("gender"));
                student.setBirthday(rst.getDate("birthday").toLocalDate());
                student.setPhone(rst.getString("phone"));
                request.getSession().setAttribute("student", student);
                response.sendRedirect("/zxc/chapter02/show-student.jsp");
            } else {
                response.sendRedirect("/zxc/chapter02/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



