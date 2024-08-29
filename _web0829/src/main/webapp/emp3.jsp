<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String num = request.getParameter("deptno");
// 데이터베이스 접속
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 680px;
	text-align: center;
}

th {
	background-color: cyan;
}

.num {
	width: 80px;
}

.title {
	width: 230px;
}

.writer {
	width: 100px;
}

.regtime {
	width: 180px;
}

a:link {
	text-decoration: none;
	color: blue;
}

a:visited {
	text-decoration: none;
	color: gray;
}

a:hover {
	text-decoration: none;
	color: red;
}
/* path 속성 바꾸기 */
svg path {
  fill: transparent; 
  stroke: red;
  stroke-width: 1;
}
</style>
</head>
<body>
<div>
	<input type="text" name="job" placeholder="Job"> 
	<input type="text" name="sal" placeholder="Sal"> 
	<input type="text" name="empno" placeholder="Empno">
	<input type="text" name="ename" placeholder="Ename"> 
	<input type="text" name="id" placeholder="ID"> 
	
	<button onclick="readEmp()">Read</button>
	<button onclick="createEmp()">Create</button>
	<button onclick="updateEmp()">Update</button>
	<button onclick="deleteEmp()">Delete</button>
	<button onclick="pushEmp()">PushEmp</button>
</div>

<!-- JSON 데이터를 출력할 영역 -->
<div class="print-data">
	<h3>Employee Data:</h3>
	<ul id="emp-list"></ul> <!-- id="emp-list"로 수정 -->
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
    let arr1 = [];
    let json = null;
		<%
		String sql = "SELECT json_object('empno', empno, 'ename', ename, 'job', job, 'sal', sal) FROM emp";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String data = rs.getString(1);
		%>
	json = JSON.parse('<%=data%>');
	arr1.push(json);
		<%
		}
		%>

	const apiUrl = 'http://localhost:3000/emp';

	function readEmp(){
		fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const empList = document.getElementById('emp-list'); // 올바른 id로 참조
            empList.innerHTML = '';  // 기존 데이터를 초기화
            data.forEach(emp => {
                empList.innerHTML += `
                    <li>
                        <strong>Empno:</strong> ${emp.empno} <br>
                        <strong>Ename:</strong> ${emp.ename} <br>
                        <strong>Job:</strong> ${emp.job} <br>
                        <strong>Sal:</strong> ${emp.sal}
                    </li>`;
            });
        })
        .catch(error => console.error('Error:', error));
	}

	function createEmp(){
		// 여기에 createEmp 로직 작성
	}

	function updateEmp(){
		// 여기에 updateEmp 로직 작성
	}

	function deleteEmp(){
		// 여기에 deleteEmp 로직 작성
	}

	function pushEmp(){
	    arr1.forEach(emp => {
	        fetch(apiUrl, {
	            method: 'POST',
	            headers: {
	                'Content-Type': 'application/json'
	            },
	            body: JSON.stringify(emp)
	        })
	        .then(response => response.json())
	        .then(data => console.log('Success:', data))
	        .catch((error) => console.error('Error:', error));
	    });
	}
</script>

</body>
</html>
