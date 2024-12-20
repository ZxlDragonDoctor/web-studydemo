<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="input-person">input-person</a><br>
<a href="order">order</a>
<hr>
<a href="login">controllerLogin</a><br>
<a href="login.jsp">ServletLogin</a>
<hr>
<h3>两种文件上传方式</h3>
<a href="uploadFile.jsp">partFileUpload</a><br>
<a href="commonsFileUpload/input-product">commonsFileUpload</a>
<h3>四种文件下载方式</h3>
<a href="dowonload.jsp">dowonload</a>
</body>
</html>