<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>学生查询</title></head>
<body>
<p><a href="../find-student-servlet">查询所有学生</a></p>
<form action = "../find-student-servlet" method="post">
  请输入学生学号：
  <input type = "text" name="stud_id" size="15">
  <input type = "submit" value = "确定">
</form>

</body>
</html>

