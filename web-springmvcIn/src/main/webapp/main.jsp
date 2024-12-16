<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/12/11
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>欢迎[${sessionScope.user.username}]访问。</h3>
<table border=1>
  <tr><td>商品号</td><td>商品名</td><td>价格</td></tr>
  <c:forEach items="${requestScope.productList}" var="product">
    <tr><td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td></tr>
  </c:forEach>
</table>

</body>
</html>
