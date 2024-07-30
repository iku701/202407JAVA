<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.ServletException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "";
String delete = request.getParameter("delete");

try {
    // 데이터베이스 연결
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(URL, "root", "mysql");

    // 삭제 처리
    if (delete != null) {
        sql = "DELETE FROM board WHERE num = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, delete);
        int result = pstmt.executeUpdate();
        if (result > 0) {
            response.sendRedirect("list.jsp"); // 삭제 후 목록 페이지 새로 고침
            return; // 페이지 리디렉션 후 추가 코드 실행 방지
        } else {
            out.println("삭제에 실패했습니다.");
        }
    }
    
    // 게시글 목록 조회
    sql = "SELECT * FROM board";
    pstmt = conn.prepareStatement(sql);
    rs = pstmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th { background-color:cyan; }
        .num { width: 80px; }
        .title { width:230px; }
        .writer { width:100px; }
        .regtime { width:180px; }
        .delete { width: 80px; }
        a:link { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover { text-decoration:none; color:red; }
    </style>
</head>
<body>
<table>
    <tr>
        <th class="num">번호</th>
        <th class="title">제목</th>
        <th class="writer">작성자</th>
        <th class="regtime">작성일시</th>
        <th class="delete">삭제</th>
    </tr>
<%
    while (rs.next()) {
        String numTmp = rs.getString("num");
        String titleTmp = rs.getString("title");
        String writerTmp = rs.getString("writer");
        String regtimeTmp = rs.getString("regtime");
%>
    <tr>
        <td><a href="view.jsp?num=<%= numTmp %>"><%= numTmp %></a></td>
        <td style="text-align:left;"><%= titleTmp %></td>
        <td><%= writerTmp %></td>
        <td><%= regtimeTmp %></td>
        <td>
        <button type="button" onclick="location.href='?delete=<%= numTmp %>'">삭제</button>
        </td>
    </tr>
<%
    }
} catch (Exception e) {
    e.printStackTrace();
    out.println("오류 발생: " + e.getMessage());
} finally {
    try {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>
</table>
<br>
<input type="button" value="돌아가기" onclick="location.href='list.jsp'">
</body>
</html>
