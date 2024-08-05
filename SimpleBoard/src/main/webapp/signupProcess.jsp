<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL, "root", "mysql");

        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, email);
        int row = pstmt.executeUpdate();

        if (row > 0) {
            out.println("<script>alert('회원가입이 완료되었습니다.'); location.href='index.jsp';</script>");
        } else {
            out.println("<script>alert('회원가입에 실패하였습니다. 다시 시도해주세요'); location.href='signup.jsp';</script>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<script>alert('잘못입력하셨습니다. 처음 화면으로 돌아갑니다.'); location.href='index.jsp';</script>");
    } finally {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>