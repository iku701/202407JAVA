<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.UserDAO, board.User" %>
<%
    String errorMessage = null;
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDao = new UserDAO();
        User user = userDao.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            response.sendRedirect("list_posts.jsp");
            return;
        } else {
            errorMessage = "Invalid username or password.";
        }
    }
%>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
<% } %>
<form method="post">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>
<a href="register.jsp">Register</a>
</body>
</html>
