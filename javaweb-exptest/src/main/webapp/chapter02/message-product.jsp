<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String message= (String)request.getSession().getAttribute("result");
%>
<p><%=message%></p>
</body>
</html>
