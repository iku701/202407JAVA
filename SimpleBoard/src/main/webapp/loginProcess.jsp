<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        String URL = "jdbc:mysql://localhost:3307/spring5fs?useUnicode=true&characterEncoding=utf8";
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, "root", "mysql");

        // 비밀번호 확인
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            int userId = rs.getInt("id");
            session.setAttribute("userId", userId);
            session.setAttribute("username", username);

            session.setAttribute("loginMessage", "어서오세요. 회원님");

            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("loginMessage", "잘못된 사용자명 또는 비밀번호입니다.");
            response.sendRedirect("login.jsp");
        }
    } catch (Exception e) {
        e.printStackTrace();
        session.setAttribute("loginMessage", "오류가 발생했습니다. 다시 시도해주세요.");
        response.sendRedirect("login.jsp");
    } finally {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>
