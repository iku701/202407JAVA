<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>구구당~</h1>
${gugu}

${result = 0; '' }
<c:forEach var = "i" begin = "1" end = "3">
	<c:forEach var = "j" begin = "2" end = "9">
		${result = i * j; ''}<br>
		<li>${i} x ${j} = ${ result}
	</c:forEach>
</c:forEach>
<br>
</body>
</html>