<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<table border="1">
  <tr><td>产品编号</td><td>产品名</td><td>品牌</td>
    <td>价格</td><td>是否删除</td></tr>
  <c:forEach var="product" items="${productList}">
    <tr><td>${product.id}</td>
      <td>${product.pname}</td>
      <td>${product.brand}</td>
      <td>${product.price}</td>
      <td><a href="../delete-product?id=${product.id}">删除</a></td>
    </tr>
  </c:forEach>
</table>
<%--<%--%>
<%--  String message = (String)request.getSession().getAttribute("result");--%>
<%--%>--%>
<%--<p><%=message%></p>--%>
</body>
</html>
