<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.javawebexptest.eneity.*" %>
<html>
<head><title>EL隐含变量的使用</title>
</head>
<body>
<h5>EL隐含变量的使用</h5>
<table border="1">
    <tr><td>EL表达式</td><td>值</td></tr>
    <tr><td>\${pageContext.request.method}</td>
        <td>${pageContext.request.method}</td>
    </tr>
    <tr><td>\${param.username}</td><td>${param.username}</td>
    </tr>
    <tr><td>\${header.host}</td><td>${header.host}</td>
    </tr>
    <tr><td>\${cookie.username.value}</td>
        <td>${cookie.username.value}</td>
    </tr>
    <tr><td>\${initParam.email}</td><td>${initParam.email}</td>
    </tr>
    <tr><td>\${sessionScope.customer.address.street}</td>
        <td>${sessionScope.customer.address.street}</td>
    </tr>
</table>
<li>${pageContext.request.method}         // 获得HTTP请求的方法，如GET或POST
<li>${pageContext.request.queryString}   // 获得请求的查询串
<li>${pageContext.request.requestURL}    // 获得请求的URL
<li>${pageContext.request.contextPath}   // 获得请求上下文路径
<li>${pageContext.session.id}              // 获得会话的ID

<li>${pageContext.servletContext.serverInfo}  //获得服务器的信息
</body></html>

