<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>百斯特电子商城</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
    <div class="header">
        <%@ include file="/WEB-INF/jsp/header.jsp"%>
    </div>
    <div class="topmenu">
        <%@ include file="/WEB-INF/jsp/topmenu.jsp"%></div>
    <div class="mainContent" class="clearfix" >
        <div class="leftmenu">
            <%@ include file="/WEB-INF/jsp/leftmenu.jsp"%></div>
        <div class="content">
            <%@ include file="/WEB-INF/jsp/content.jsp"%></div>
    </div>
    <div class="footer">
        <%@ include file="/WEB-INF/jsp/footer.jsp"%></div>
</div>
</body>
</html>
