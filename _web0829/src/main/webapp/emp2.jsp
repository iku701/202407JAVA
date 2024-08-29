<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Result</title>
<style>
table {
	width: 680px;
	text-align: center;
	margin-top: 20px;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 8px;
}

th {
	background-color: cyan;
}
</style>
</head>
<body>
	<h2>JSON Result from MySQL</h2>
	<table>
		<tr>
			<th>JSON Data</th>
		</tr>
		<%
		String sql = "select JSON_OBJECT('EMPNO', EMPNO, 'ENAME', ENAME, 'JOB', JOB, 'SAL', SAL) as emp_json from EMP";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String json_object_str = rs.getString("emp_json");
		%>
		<tr>
			<td><%=json_object_str%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
