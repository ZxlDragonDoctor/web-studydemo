<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/6
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${stu.name}
${stu.gender}

<table border="1">
    <tr><td>学号</td><td>姓名</td><td>性别</td>
        <td>出生日期</td><td>电话</td><td>是否删除</td></tr>
    <c:forEach var="student" items="${stus}" >
        <tr><td>${student.studId}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.birthday}</td>
            <td>${student.phone}</td>
            <td><a href="delete-student?id=${student.studId}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
