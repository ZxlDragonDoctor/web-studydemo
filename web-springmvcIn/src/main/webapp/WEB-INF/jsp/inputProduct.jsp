<%--
  Created by IntelliJ IDEA.
  User: 朱小龙
  Date: 2024/12/20
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>批量文件上传</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="/zxl/commonsFileUpload/save-product">
    <fieldset>
        <legend>添加产品信息</legend>
        <table>
            <tr><td>产品Id：</td><td><input type="text" name="id" ></td></tr>
            <tr><td>产品名称：</td><td><input type="text" name="name" ></td></tr>
            <tr><td>产品品牌：</td><td><input type="text" name="brand" ></td></tr>
            <tr><td>产品价格：</td><td><input type="number" name="price" ></td></tr>
            <tr><td>产品图片：</td>
               <td> <label for="files">选择文件:</label>
                <input type="file" name="images" multiple="multiple" id="files">
            </td></tr>
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