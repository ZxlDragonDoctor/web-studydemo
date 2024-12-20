<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <table border='0'>
        <tr>
        <td><a href="index.jsp">【首页】</a></td>
        <td>
        <form action="user-login3" method="post" name="login" >
        用户名<input type="text" name="username" size="13" />
        密  码 <input type="password" name="password" size="13"  />
        <input type="submit" name="submit" value="登  录">
        <input type="button" name="register" value="注  册"
        onclick="check();">
        </form>
        </td>
        <td><a href="showOrder">我的订单</a>|</td>
        <td><a href="showCart">查看购物车</a></td>
        </tr>
        </table>
