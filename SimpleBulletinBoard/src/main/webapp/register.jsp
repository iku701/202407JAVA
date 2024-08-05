<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.UserDAO, board.User" %>
<%
    String errorMessage = null;
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDao = new UserDAO();
        User existingUser = userDao.getUserByUsername(username);

        if (existingUser == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            userDao.registerUser(user);
            response.sendRedirect("login.jsp");
            return;
        } else {
            errorMessage = "Username already exists.";
        }
    }
%>
<html>
<head><title>Register</title></head>
<body>
<h2>Register</h2>
<% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
<% } %>
<form method="post">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    <input type="submit" value="Register">
</form>
<a href="login.jsp">Login</a>
</body>
</html>
