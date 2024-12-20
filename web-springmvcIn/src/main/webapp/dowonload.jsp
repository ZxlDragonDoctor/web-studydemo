<%--
  Created by IntelliJ IDEA.
  User: 朱小龙
  Date: 2024/12/20
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>download File</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/download/example.txt">下载 example.txt</a><br/>
<a href="file-download?filename=/images/hwphone4.jpg">下载图片hwphone4.jpg</a><br/>
<a href="aadownload/phone.jpg">下载图片phone.jpg</a><br/>
<a href="office-download?doctype=word">下载word</a><br/>
<a href="office-download?doctype=excel">下载excel</a><br/>
</body>
</html>
