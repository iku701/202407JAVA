<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int postId = Integer.parseInt(request.getParameter("id"));
    String title = "";
    String content = "";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        request.setCharacterEncoding("UTF-8");
        String URL = "jdbc:mysql://localhost:3307/spring5fs?useUnicode=true&characterEncoding=UTF-8"; 
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, "root", "mysql");

        String sql = "SELECT * FROM posts WHERE id = ? AND user_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, postId);
        pstmt.setInt(2, userId);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            title = rs.getString("title");
            content = rs.getString("content");
        } else {
            out.println("<script>alert('잘못된 접근입니다.'); location.href='board.jsp';</script>");
            return;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit - www.hightech.co.kr</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .edit-form {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        .edit-form label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        .edit-form input[type="text"],
        .edit-form textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }
        .edit-form button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .edit-form button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <header>
        <div class="inner">
            <h1><a href="index.jsp">InnovateTech</a></h1>
        </div>
    </header>

    <section>
        <div class="inner">
            <h1>게시글 수정</h1>
            <form action="updatePost.jsp" method="post" class="edit-form">
                <input type="hidden" name="id" value="<%= postId %>">
                <label for="title">제목:</label>
                <input type="text" id="title" name="title" value="<%= title %>" required><br>
                <label for="content">내용:</label>
                <textarea id="content" name="content" required><%= content %></textarea><br>
                <button type="submit">수정 완료</button>
            </form>
        </div>
    </section>

    <footer>
        <div class="inner">
            <div class="upper">
                <h1>INNOVATETECH</h1>
                <ul>
                    <li><a href="#">How to come</a></li>
                    <li><a href="#">Policy</a></li>
                    <li><a href="#">Terms</a></li>
                    <li><a href="#">Family Site</a></li>
                    <li><a href="#">Sitemap</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    7 Gukhoe-daero 70-gil, Yeongdeungpo-gu, Seoul<br>
                    TEL: 031-111-1234 C.P: 010-1234-5678
                </address>
                <p>
                <p>2020 INNOVATETECH &copy; copyright all rights reserved.</p>
                </p>
            </div>
        </div>
    </footer>

</body>
</html>
