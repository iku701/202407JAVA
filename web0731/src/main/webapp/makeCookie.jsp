<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Cookie cookie = new Cookie("loginid", "Lee1"); 		//(key,value)
response.addCookie(cookie);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>make cookie</title>
</head>
<body>
<%= cookie.getName() %><br>
<%= cookie.getValue() %>
</body>
</html>