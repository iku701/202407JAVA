<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/web0725_1/Register" method="post">
    이름: <input type="text" name="name" required><br>
    SSN: <input type="text" name="ssn" required><br>
    전화번호: <input type="text" name="tel" required><br>
    초기 잔액: <input type="number" name="balance" required><br>
    <input type="submit" value="회원가입">
</form>
<a href="/web0725_1/Index.jsp">돌아가기</a>
</body>
</html>
