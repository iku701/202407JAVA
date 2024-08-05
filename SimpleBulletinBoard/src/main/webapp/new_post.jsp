<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.PostDAO, board.Post, board.User" %>
<%
    User loggedInUser = (User) session.getAttribute("user");
    if (loggedInUser == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = loggedInUser.getUsername();
        
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        
        PostDAO dao = new PostDAO();
        dao.addPost(post);
        
        response.sendRedirect("list_posts.jsp");
    }
%>
<html>
<head><title>새 게시물 작성</title></head>
<body>
<h2>새 게시물 작성</h2>
<form method="post">
    제목: <input type="text" name="title" required><br>
    내용: <textarea name="content" required></textarea><br>
    <input type="submit" value="작성">
</form>
</body>
</html>
