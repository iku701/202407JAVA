<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Cart List</title>
</head>
<body>
    <h1>Add Cart List</h1>
    <a href="${pageContext.request.contextPath}/products.jsp">Home</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Product_id</th>
            <th>Quantity</th>            
            <th>Actions</th>
        </tr>
        <c:forEach var="cartProducts" items="${cartProducts}">
            <tr>
                <td>${cartProducts.id}</td>
                <td>${cartProducts.name}</td>
                <td>${cartProducts.description}</td>
                <td>${cartProducts.price}</td>
                <td>${cartProducts.stock}</td>
                <td>${cartProducts.product_id}</td>
                <td>${cartProducts.quantity}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/addCart.jsp/${product.id}">Add to Cart</a>
                    <a href="${pageContext.request.contextPath}/selectOneForUpdate.jsp?id=${product.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/products/delete/${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>