<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<h1>회원 탈퇴</h1>
<form action="/web0725_1/Delete" method="post">
    이름: <input type="text" name="name" required><br>
    SSN: <input type="text" name="ssn" required><br>
    <input type="submit" value="회원 탈퇴">
</form>
<br>
<a href="/web0725_1/Index.jsp">처음으로</a>
</body>
</html>
