<%--
  Created by IntelliJ IDEA.
  User: 朱小龙
  Date: 2024/12/20
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="file-upload" enctype="multipart/form-data" method="post">
    <fieldset>
        <legend>文件上传</legend>
        <p>
            <label>会员号:</label>
            <input type="text" name="mnumber" size="30"/>
        </p>
        <p>
            <label>文件名:</label>
            <input type="file" name="fileName" size="30"/>
        </p>
        <p id="buttons">
            <input id="submit" type="submit" tabindex="4" value="提交">
            <input id="reset" type="reset" tabindex="5" value="重置">
        </p>
    </fieldset>
</form>
</body>
</html>
