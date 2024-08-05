<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.PostDAO, board.Post" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    PostDAO dao = new PostDAO();
    Post post = dao.getPostById(id);
%>
<html>
<head><title><%= post.getTitle() %></title></head>
<body>
<h2><%= post.getTitle() %></h2>
<p><%= post.getContent() %></p>
<p>작성자: <%= post.getAuthor() %></p>
<p>작성일자: <%= post.getCreatedDate() %></p>
<a href="list_posts.jsp">목록으로 돌아가기</a>
</body>
</html>
