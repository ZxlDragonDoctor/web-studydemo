<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/30
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="save-user">
    <fieldset>
    <legend>添加用户信息</legend>
    <table>
    <tr>
    <td><form:label path="username">用户名</form:label></td>
    <td><form:input path="username" /></td>
    </tr>
    <tr>
    <td><form:label path="password">口令</form:label></td>
    <td><form:password path="password" /></td>
    </tr>
    <tr>
    <td><form:label path="gender">性别</form:label></td>
    <td>
    <form:radiobutton path="gender" value="M" label="男" />
    <form:radiobutton path="gender" value="F" label="女" />
    </td>
    </tr>
    <tr>
    <td><form:label path="resume">简历</form:label></td>
    <td><form:textarea path="resume" rows="5" cols="30" /></td>
    </tr>
    <tr>
    <td><form:label path="hobby">业余爱好</form:label></td>
    <td><form:checkboxes path="hobby" items="${hobbyList}" /></td>
    </tr>
    <tr>
    <td><form:label path="language">精通的语言</form:label></td>
    <td>
    <form:radiobuttons path="language" items="${languageList}" />        	         </td>
    </tr>
    <tr>
    <td><form:label path="education">学历</form:label></td>
    <td>
    <form:select path="education">
        <form:option value="NONE" label="Select"/>
        <form:options items="${educationList}" />
    </form:select>
    </td>
    </tr>
    <tr>
    <td><form:label path="skills">技能</form:label></td>
    <td>
    <form:select path="skills" items="${skillsList}"
                 multiple="true" />
    </td>
    </tr>
        <tr>
            <td><form:label path="receiveEmail">是否订阅邮件</form:label></td>
            <td><form:checkbox path="receiveEmail" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
    </fieldset>
</form:form>

    </body>
</html>
