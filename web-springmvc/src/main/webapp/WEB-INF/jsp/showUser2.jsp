<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/30
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <fieldset>
    <legend>用户信息如下</legend>
    <table>
      <tr><td>用户名</td><td>${username}</td></tr>
      <tr><td>口令</td><td>${password}</td></tr>
      <tr>
        <td>性别</td>
        <td>${(gender=="M"? "男" : "女")}</td>
      </tr>
      <tr><td>简历</td><td>${resume}</td></tr>
      <tr>
        <td>业余爱好</td>
        <td>
          <c:forEach var="hobby" items="${hobbyList}" varStatus="status">
            ${hobby} <c:if test="${!status.last}">,</c:if>
          </c:forEach>
        </td>
      </tr>
      <tr><td>精通的语言</td><td>${languageList}</td></tr>
      <tr><td>学历</td><td>${education}</td></tr>
      <tr>
        <td>技能</td>
        <td>
          <c:forEach var="skill" items="${skills}" varStatus="status">
            ${skill}<c:if test="${!status.last}">,</c:if>
          </c:forEach>
        </td>
      </tr>
      <tr>
        <td>是否接收邮件</td><td>${receiveEmail}</td>
      </tr>
    </table>
  </fieldset>

  </body>
</html>
