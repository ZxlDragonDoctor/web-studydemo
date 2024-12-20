<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>访问集合元素</title>
</head>
<body>
<p>访问集合元素</p>
<ul>
    <li> ${country[0]}的首都是：${capital["China"]}
    <li> ${country[1]}的首都是：${capital["England"]}
    <li> ${country[2]}的首都是：${capital.Russia}
</ul>
</body>
</html>