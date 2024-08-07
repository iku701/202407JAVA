<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("name", "홍길동");	
	request.setAttribute("money", 5000);	
	request.setAttribute("dataList", new String[]{"a", "b", "c"});	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${name == '홍길동' }">
	이름은 홍길동입니다.<br>
</c:if>

<c:choose>
	<c:when test = "${money >= 10000 }">
	im a rich.
	</c:when>
	<c:when test = "${money > 0 }">
	im a little rich.
	</c:when>
	<c:otherwise>
	nothing.
	</c:otherwise>
</c:choose>
<br>

<c:forEach var = "count" begin = "0" end = "30" step = "3">
	${count}
</c:forEach>
<br>

${sum = 0; ''}

<c:forEach var = "i" begin = "1" end = "10"  >
	${sum = sum + i; ''}
</c:forEach>

1부터 10까지의 합 : ${sum}

${result = 0; '' }
<c:forEach var = "i" begin = "1" end = "9">
	<c:forEach var = "j" begin = "2" end = "9">
		${result = i * j; ''}<br>
		<li>${i} x ${j} = ${ result}
	</c:forEach>
</c:forEach>
<br>

</body>
</html>