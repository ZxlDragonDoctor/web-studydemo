<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<form action="home" method="post">
    <fieldset>
        <legend>用户登录</legend>
        <p>
            <label>用户名: <input type="text" name="username"/></label>
        </p>
        <p>
            <label>密&nbsp;&nbsp;码：<input type="password" name="password"/>
            </label>
        </p>
        <p>
            <label><input type="submit" value="登录"/>
                <input type="reset" value="取消"/>
            </label>
        </p>
    </fieldset>
</form>
<p>${message}</p>
</body>
</html>
