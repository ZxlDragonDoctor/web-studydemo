<%--
  Created by IntelliJ IDEA.
  User: 朱小龙
  Date: 2024/12/20
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>产品信息上传成功</h1>
<p>产品ID:${product.id}</p>
<p>产品名称:${product.name}</p>
<p>产品品牌:${product.brand}</p>
<c:forEach var="item" items="${product.images}">
    <li>${item.getOriginalFilename()}
        <img width="100" src='<c:url value="/images/" />${item.getOriginalFilename()}'/>
    </li>
</c:forEach>
</body>
</html>
