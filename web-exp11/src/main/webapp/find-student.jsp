<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>学生查询</title></head>
<body>
<p><a href="find-student">查询所有学生</a></p>
<form action = "find-mystudent" method="post">
  请输入姓名或性别进行查询：
  <input type = "text" name="name" size="15">
  <input type = "text" name="gender" size="15">
  <input type = "submit" value = "确定">
</form>
</body>
</html>

