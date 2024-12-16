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
<p>测试Session作用域</p>
<p>testModelRequestDomain:${testModelRequestDomain}</p>
<p>testMapRequestDomain:${testMapRequestDomain}</p>
<p>testModelMapRequestDomain:${testModelMapRequestDomain}</p>
<p>testModelAndViewRequestDomain:${testModelAndViewRequestDomain}</p>
<hr>
<p>testModelSessionDomain:${testModelSessionDomain}</p>
<p>testMapSessionDomain:${testMapSessionDomain}</p>
<p>testModelMapSessionDomain:${testModelMapSessionDomain}</p>

<%--这里数据拼接到uri后面了--%>
<p>testModelAndViewSessionDomain:${param.testModelAndViewSessionDomain}</p>

<p>testServletAPISessionDomain:${testServletAPISessionDomain}</p>
<hr>
<p>testFlashAttribute:${testFlashAttribute}</p>
</body>
</html>
