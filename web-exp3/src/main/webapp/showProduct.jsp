<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/18
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
<c:forEach var="product" items="${productList}" >
    <tr><td>${product.id}</td>
        <td>${product.pname}</td>
        <td>${cat.cate_name}</td>

        <td><img src="${product.image}" width="100" height="100"/></td>
        <td>${product.brand}</td>
        <td>${product.price}</td>
        <td><a href="delete-product?id=${product.id}">删除</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
