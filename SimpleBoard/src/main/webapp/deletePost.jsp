<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    int postId = Integer.parseInt(request.getParameter("id"));

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
    	String URL = "jdbc:mysql://localhost:3307/spring5fs";

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL, "root", "mysql");

        String sql = "DELETE FROM posts WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, postId);
        int row = pstmt.executeUpdate();

        if (row > 0) {
            out.println("<script>alert('게시글 삭제 완료!'); location.href='board.jsp';</script>");
        } else {
            out.println("<script>alert('게시글 삭제 실패. 다시 시도해주세요.'); location.href='board.jsp';</script>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<script>alert('오류가 발생했습니다. 다시 시도해주세요.'); location.href='board.jsp';</script>");
    } finally {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>