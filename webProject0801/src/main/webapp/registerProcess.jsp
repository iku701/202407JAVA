<%@page import="account.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 처리</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .message {
            margin: 20px 0;
        }
        .message.success {
            color: #28a745;
        }
        .message.error {
            color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
       	    request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            
            AccountDAO dao = new AccountDAO();
            boolean isRegistered = dao.registerUser(username, password, email);
            
            if (isRegistered) {
        %>
                <div class="message success">회원 가입 성공! <a href="login.jsp">로그인 페이지로 이동</a></div>
        <%
            } else {
        %>
                <div class="message error">회원 가입 실패! <a href="register.jsp">다시 시도</a></div>
        <%
            }
        %>
    </div>
</body>
</html>
