<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/12/12
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>请求监听器示例</title></head>
<body>
欢迎您，您的IP地址是${pageContext.request.remoteAddr}<br>
<p>自应用程序启动以来，该页面被访问了
  <font color="blue">${applicationScope.count}
  </font>次</p><br>
</body>
</html>
