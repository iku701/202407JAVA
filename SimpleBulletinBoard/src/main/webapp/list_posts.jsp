<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.PostDAO, board.Post, board.User" %>
<%
    User loggedInUser = (User) session.getAttribute("user");
%>
<html>
<head><title>게시물 목록</title></head>
<body>
<h2>게시물 목록</h2>
<% if (loggedInUser != null) { %>
    <a href="new_post.jsp">새 게시물 작성</a>
    <a href="logout.jsp">로그아웃</a>
<% } else { %>
    <a href="login.jsp">로그인</a>
    <a href="register.jsp">회원가입</a>
<% } %>
<table border="1">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일자</th>
    </tr>
    <%
        PostDAO dao = new PostDAO();
        List<Post> posts = dao.getAllPosts();
        for (Post post : posts) {
    %>
    <tr>
        <td><%= post.getId() %></td>
        <td><a href="view_post.jsp?id=<%= post.getId() %>"><%= post.getTitle() %></a></td>
        <td><%= post.getAuthor() %></td>
        <td><%= post.getCreatedDate() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
