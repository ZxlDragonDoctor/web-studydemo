<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/30
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class ="container">
  <h5>已经保存如下图书信息</h5>
  <p>书号: ${book.isbn}</p>
  <p>书名: ${book.name}</p>
  <p>作者: ${book.author}</p>
  <p>出版日期: ${book.pubdate}</p>
  <p>价格: $${book.price}</p>
</div>
</body>
</html>
