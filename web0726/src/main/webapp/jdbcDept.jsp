<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
out.println("드라이버 로딩!!");
conn = DriverManager.getConnection(URL, "root", "mysql");
out.println("mysql 접속!!");

String loc = request.getParameter("loc");
String sql;
if(loc != null && !loc.isEmpty()){
	sql = "select * from dept where loc = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, loc);
}else{
	sql = "select * from dept";
	pstmt = conn.prepareStatement(sql);
}

ResultSet rs = pstmt.executeQuery();
boolean isEmpty = true;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
지역 : <input type = "text" name = "loc">
<input type = "submit">
</form>
<table border = "50">
<%
while(rs.next()){
	isEmpty = false;
	String deptno = rs.getString("deptno");
	String dname = rs.getString("dname");
	String locValue = rs.getString("loc");
//	out.println(deptno);
%>
<tr>
<td><%=deptno %></td><td><%= dname %></td><td><%= locValue %></td>
</tr>
<%
}
%>

<%
if(isEmpty){
//	out.println("");
%>
<tr>
<td colspan = '3'>지역명이 맞지않습니다.</td>
</tr>
<%
}
%>
</table>
</body>
</html>