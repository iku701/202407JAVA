<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
//데이터베이스 접속
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(URL, "root", "mysql");

    // 게시글 추가
    String sql = "INSERT INTO board(writer, title, content, regtime, hits) VALUES (?, ?, ?, NOW(), 0)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, writer);
    pstmt.setString(2, title);
    pstmt.setString(3, content);
    pstmt.executeUpdate();
    
    // 성공적으로 추가 후 목록 페이지로 리다이렉트
    response.sendRedirect("list.jsp");
} catch (Exception e) {
    e.printStackTrace();
    out.println("게시글 추가 중 오류 발생: " + e.getMessage());
} finally {
    try {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력 성공!</h1>
</body>
</html>