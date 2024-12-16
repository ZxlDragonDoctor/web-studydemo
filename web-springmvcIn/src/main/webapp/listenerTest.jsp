<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/12/12
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="java.sql.*,javax.sql.*" %>
<%
  DataSource dataSource =
          (DataSource)application.getAttribute("dataSource");
  Connection conn = dataSource.getConnection();
  Statement stmt = conn.createStatement();
  ResultSet rst = stmt.executeQuery("SELECT * FROM students");
%>
<table border="1">
  <caption>学生表中信息</caption>
  <tr><td>学号</td><td>学生姓名</td><td>性别</td>
    <td>生日</td><td>电话</td></tr>
      <% while (rst.next()){ %>
  <tr><td><%= rst.getInt(1) %></td>
    <td><%= rst.getString(2) %></td>
    <td><%= rst.getString(3) %></td>
    <td><%= rst.getString(4) %></td>
    <td><%= rst.getFloat(5) %></td>
  </tr>
  <% } %>
</table>

</body>
</html>
