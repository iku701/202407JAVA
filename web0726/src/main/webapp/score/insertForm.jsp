<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 점수 입력</title>
</head>
<body>
<form action="insertResult.jsp" method="get">
	학번: <input type="text" name="num"><br>
	이름: <input type="text" name="name"><br>
    국어: <input type="text" name="kor"><br>
    영어: <input type="text" name="eng"><br>
    수학: <input type="text" name="math"><br>
    <input type="submit" value="확인"> 
</form>
<a href="/web0726/score/viewScore.jsp">점수확인</a>
</body>
</html>