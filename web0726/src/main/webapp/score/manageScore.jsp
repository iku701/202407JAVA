<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num3 = "";
String name3 = "";
String kor3 = "";
String eng3 = "";
String math3 = "";

request.setCharacterEncoding("UTF-8");
String find = request.getParameter("find");
String update = request.getParameter("update");
String delete = request.getParameter("delete");
String num = request.getParameter("num");
String name = request.getParameter("name");
String kor = request.getParameter("kor");
String eng = request.getParameter("eng");
String math = request.getParameter("math");

String sql = "";
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;

Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

// 데이터 삭제
if (delete != null) {
    sql = "DELETE FROM score WHERE num = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, delete);
    int result = pstmt.executeUpdate();
    if (result > 0) {
        out.println("데이터가 성공적으로 삭제되었습니다.");
    } else {
        out.println("삭제에 실패했습니다.");
    }
}

// 데이터 삽입
if (num != null && update == null && delete == null) {
    sql = "INSERT INTO score(num, name, kor, eng, math) VALUES (?,?,?,?,?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, num);
    pstmt.setString(2, name);
    pstmt.setString(3, kor);
    pstmt.setString(4, eng);
    pstmt.setString(5, math);
    int result = pstmt.executeUpdate();
    if(result > 0){
    	out.println("데이터가 성공적으로 삽입되었습니다.");
    }else{
    	out.println("삽입에 실패했습니다.");
    }
}

// 데이터 조회
if (find != null) {
    sql = "SELECT * FROM score WHERE num = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, find);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
        num3 = rs.getString("num");
        name3 = rs.getString("name");
        kor3 = rs.getString("kor");
        eng3 = rs.getString("eng");
        math3 = rs.getString("math");
    }
}

// 데이터 수정
if (update != null && delete == null) {
    sql = "UPDATE score SET name = ?, kor = ?, eng = ?, math = ? WHERE num = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, name);
    pstmt.setString(2, kor);
    pstmt.setString(3, eng);
    pstmt.setString(4, math);
    pstmt.setString(5, num);
    int result = pstmt.executeUpdate();
    if (result > 0) {
        out.println("데이터가 성공적으로 업데이트되었습니다.");
    } else {
        out.println("업데이트에 실패했습니다.");
    }
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <style>
        table { width: 600px; text-align: left; }
        th    { width: 40px; background-color: cyan; }
    </style>
<title>학생 점수 관리 프로그램</title>
</head>
<body>
<form method="post">
    학번: <input type="text" name="num" value="<%= num3 %>"><br>
    이름: <input type="text" name="name" value="<%= name3 %>"><br>
    국어: <input type="text" name="kor" value="<%= kor3 %>"><br>
    영어: <input type="text" name="eng" value="<%= eng3 %>"><br>
    수학: <input type="text" name="math" value="<%= math3 %>"><br>
    <input type="submit" value="입력">
    <button type="submit" name="update" value="OK">수정</button>
</form>
<table>
    <tr>
        <th>번호</th><th>이름</th>
        <th>국어</th><th>영어</th><th>수학</th>
        <th>총점</th><th>평균</th><th>삭제</th>
    </tr>
<%
sql = "SELECT * FROM score";
pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

while (rs.next()) {
    String num1 = rs.getString("num");
    String name1 = rs.getString("name");
    String kor1 = rs.getString("kor");
    String eng1 = rs.getString("eng");
    String math1 = rs.getString("math");
    int tot = Integer.parseInt(kor1) + Integer.parseInt(eng1) + Integer.parseInt(math1);
    double avg = tot / 3.0;
%>
<tr>
    <td><a href="?find=<%= num1 %>"><%= num1 %></a></td>
    <td><%= name1 %></td>
    <td><%= kor1 %></td>
    <td><%= eng1 %></td>
    <td><%= math1 %></td>
    <td><%= tot %></td>
    <td><%= avg %></td>
    <td><button type="button" onclick="location.href='?delete=<%= num1 %>'">삭제</button></td>
</tr>
<%
}
%>
</table>
</body>
</html>
