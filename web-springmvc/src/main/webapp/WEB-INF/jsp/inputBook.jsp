<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/30
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
<div class="container">
<%--@elvariable id="book" type="com.zxl.webspringmvc.webspringmvc.entity.Book"--%>
<form:form modelAttribute="book" action="save-book2" method="post">
  <fieldset>
  <legend>添加图书信息</legend>
  <p>
  <label for="isbn">书号: </label>
  <form:input id="isbn" path="isbn" tabindex="1"/>
  </p>
  <p>
  <label for="name">书名: </label>
  <form:input id="name" path="name" tabindex="2"/>
  </p>
  <p>
  <label for="author">作者: </label>
  <form:input id="author" path="author" tabindex="3"/>
  </p>
    <p>
      <form:errors path="pubdate" cssClass="error"/>
    </p>
    <p>
      <label for="pubdate">出版日期: </label>
      <form:input id="pubdate" path="pubdate" tabindex="4"/>
      (yyyy-MM-dd)
    </p>
    <p>
      <label for="price">价格: </label>
      <form:input id="price" path="price" tabindex="5"/>
    </p>
    <p class="buttons">
      <input id="reset" type="reset" tabindex="6" value="重置">
      <input id="submit" type="submit" tabindex="7" value="保存">
    </p>
  </fieldset>
  </form:form>

  </body>
</html>
