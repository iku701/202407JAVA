<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    request.setCharacterEncoding("UTF-8");
    Integer userId = (Integer) session.getAttribute("userId");
    String username = (String) session.getAttribute("username");
    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board - www.hightech.co.kr</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap">
    
    <style>
        /* board.jsp에 css가 적용되지않아서 스타일태그를 추가했습니다.. */
        body {
            font-family: 'Noto Sans KR', sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            color: #333;
        }

        .board {
            width: 100%;
            padding: 40px 0;
            background: #f9f9f9;
        }
        .board .inner {
            width: 1180px;
            margin: 0 auto;
        }
        .board h1 {
            font-size: 40px;
            color: #333;
            margin-bottom: 20px;
        }
        .board .username {
            font-size: 16px;
            color: #666;
            margin-bottom: 20px;
        }

        .post-form {
            background: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        .post-form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .post-form input[type="text"], .post-form textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .post-form button {
            background-color: #81C784; 
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .post-form button:hover {
            background-color: #45a049; 
        }

        .post-list {
            margin-top: 20px;
        }
        .post {
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 20px;
        }
        .post h3 {
            font-size: 20px;
            margin-bottom: 10px;
        }
        .post p {
            margin-bottom: 10px;
        }
        .post small {
            display: block;
            font-size: 14px;
            color: #666;
        }
        .post-actions {
            margin-top: 10px;
        }
        .post-actions button {
            background-color: #808080; 
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            margin-right: 5px;
        }
        .post-actions button:hover {
            background-color: #505050; 
        }

        .post-actions .delete-btn {
            background-color: #E57373; 
        }
        .post-actions .delete-btn:hover {
            background-color: #D32F2F; 
        }
    </style>
    <script>
        function editPost(postId) {
            window.location.href = 'editPost.jsp?id=' + postId;
        }

        function confirmDelete(postId) {
            if (confirm('정말로 삭제하시겠습니까?')) {
                window.location.href = 'deletePost.jsp?id=' + postId;
            }
        }
    </script>
</head>
<body>

    <header>
        <div class="inner">
            <h1><a href="index.jsp">InnovateTech</a></h1>
        </div>
    </header>

    <main>
        <section class="board">
            <div class="inner">
                <h1>사내 게시판</h1>
                <p class="username">사용자명: <%= username %></p>
                
                <form action="createPost.jsp" method="post" class="post-form">
                    <input type="hidden" name="userId" value="<%= userId %>">
                    <label for="title">제목:</label>
                    <input type="text" id="title" name="title" required>
                    <label for="content">내용:</label>
                    <textarea id="content" name="content" required></textarea>
                    <button type="submit">게시글 작성</button>
                </form>

                <h2>게시글 목록</h2>
                <div class="post-list">
                    <%
                        request.setCharacterEncoding("UTF-8");
                        Connection conn = null;
                        Statement stmt = null;
                        ResultSet rs = null;

                        try {
                            String URL = "jdbc:mysql://localhost:3307/spring5fs";
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection(URL, "root", "mysql");

                            String sql = "SELECT posts.*, users.username FROM posts JOIN users ON posts.user_id = users.id ORDER BY posts.created_at DESC";
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);

                            while (rs.next()) {
                                int id = rs.getInt("id");
                                int postUserId = rs.getInt("user_id");
                                String postUsername = rs.getString("username");
                                String title = rs.getString("title");
                                String content = rs.getString("content");
                                Timestamp createdAt = rs.getTimestamp("created_at");
                    %>
                        <div class="post">
                            <h3><%= title %></h3>
                            <p><%= content %></p>
                            <small>작성자: <%= postUsername %>, 작성일: <%= createdAt %></small>
                            <% if (postUserId == userId) { %>
                                <div class="post-actions">
                                    <button class="edit-btn" onclick="editPost(<%= id %>)">수정</button>
                                    <button class="delete-btn" onclick="confirmDelete(<%= id %>)">삭제</button>
                                </div>
                            <% } %>
                        </div>
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (rs != null) rs.close();
                            if (stmt != null) stmt.close();
                            if (conn != null) conn.close();
                        }
                    %>
                </div>
            </div>
        </section>
    </main>

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
