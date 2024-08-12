<%@page import="shop.CartProducts"%>
<%@page import="shop.CartDAO"%>
<%@page import="shop.ProductDAO"%>
<%@page import="shop.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
CartDAO cartDAO = new CartDAO();
List<CartProducts> cartProducts = cartDAO.viewCart();
request.setAttribute("cartProducts", cartProducts);
%>
<jsp:forward page="viewCartList.jsp"/>	
