<%@ page import="com.zxl.webexp3.webexp3.eneity.Categories" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zxl.webexp3.webexp3.Dao.impl.ProductDaoImpl" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="categories" class="com.zxl.webexp3.webexp3.eneity.Categories" scope="session" />
        <p><b>商品分类</b></p>
        <ul>
<%
        ProductDaoImpl pdi = new ProductDaoImpl();
        List<Categories> categoryList=pdi.findAllCategories();
        for(Categories category:categoryList){
                Integer cate_id=category.getCate_id();
%>
        <li><a href="show-product?cate_id=<%=cate_id%>"><%=category.getCate_name()%></a></li>
        </ul>
<%}%>