<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/12/5
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="show-person">
<fieldset>
  <legend>添加用户信息</legend>
  <table>
      <tr><td>身份证号：</td><td><input type="text" name="id" ></td></tr>
      <tr><td>用户名：</td><td><input type="text" name="name" ></td></tr>
      <tr><td>年龄：</td><td><input type="number" name="age" ></td></tr>
      <tr><td>电话号码：</td><td><input type="text" name="phonenumber" ></td></tr>
      <tr><td>电子邮箱：</td><td><input type="text" name="email" ></td></tr>
      <tr><td>性别</td>
          <td>
              <input type="radio" name="sex" value='male' checked/><label>男</label>
              <input name="sex" type="radio" value="female"/><label>女</label>
          </td>
      </tr>
      <tr><td>个人主页：</td><td><input type="text" name="homepage" ></td></tr>
      <tr><td>薪资：</td><td><input type="text" name="salary" ></td></tr>
      <tr><td>信用卡号：</td><td><input type="text" name="creditCardNumber" ></td></tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="提交"/>
          </td>
        </tr>
      </table>
    </fieldset>
</form>
</body>
</html>
