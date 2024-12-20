<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>错误页面</title>
</head>
<body>
<% double k= (double)pageContext.getAttribute("number");%>
<p>k is :<%=k%></p><br/>
</body>
</html>