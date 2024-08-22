<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome, ${sessionScope.user}!</h2>
    <p>You have successfully logged in.</p>
    <form action="logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
