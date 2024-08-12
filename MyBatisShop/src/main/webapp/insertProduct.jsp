<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3307/spring5fs?useUnicode=true&characterEncoding=UTF-8"
    user="root" password="mysql"/>

<c:set var="name" value="${param.name}" />
<c:set var="description" value="${param.description}" />
<c:set var="price" value="${param.price}" />
<c:set var="stock" value="${param.stock}" />

<c:if test="${not empty name and not empty description and not empty price and not empty stock}">
    ${ProductDAO.addProduct(product)}
    <jsp:forward page="products.jsp"/>
</c:if>

