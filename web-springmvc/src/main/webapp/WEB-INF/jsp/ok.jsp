<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/30
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--测试testFlashAttribute是否重定向到这儿--%>
<p>测试Request作用域</p>
<p>testModelRequestDomain:${testModelRequestDomain}</p>
<p>testMapRequestDomain:${testMapRequestDomain}</p>
<p>testModelMapRequestDomain:${testModelMapRequestDomain}</p>
<p>testModelAndViewRequestDomain:${testModelAndViewRequestDomain}</p>
<p>testServletAPIRequestDomain:${testServletAPIRequestDomain}</p>
<p>Session作用域</p>
<p>testFlashAttribute:${testFlashAttribute}</p>
</body>
</html>
