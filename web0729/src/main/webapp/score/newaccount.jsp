<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String idTmp = "";
String nameTmp = "";
String ssnTmp = "";
String telTmp = "";
String balanceTmp = "";

request.setCharacterEncoding("UTF-8");
String find = request.getParameter("find");
String update = request.getParameter("update");
String delete = request.getParameter("delete");
String id = request.getParameter("id");
String name = request.getParameter("name");
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");
String balance = request.getParameter("balance");

String sql = "";
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;

Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

// 데이터 삭제
if (delete != null) {
    sql = "DELETE FROM account WHERE id = ?";
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
if (id != null && update == null && delete == null) {
    sql = "INSERT INTO account(id, name, ssn, tel, balance) VALUES (?,?,?,?,?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    pstmt.setString(2, name);
    pstmt.setString(3, ssn);
    pstmt.setString(4, tel);
    pstmt.setString(5, balance);
    int result = pstmt.executeUpdate();
    if(result > 0){
        out.println("데이터가 성공적으로 삽입되었습니다.");
    }else{
        out.println("삽입에 실패했습니다.");
    }
}

// 데이터 조회
if (find != null) {
    sql = "SELECT * FROM account WHERE id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, find);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
        idTmp = rs.getString("id");
        nameTmp = rs.getString("name");
        ssnTmp = rs.getString("ssn");
        telTmp = rs.getString("tel");
        balanceTmp = rs.getString("balance");
    }
}

// 데이터 수정
if (update != null && delete == null) {
    sql = "UPDATE account SET name = ?, ssn = ?, tel = ?, balance = ? WHERE id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, name);
    pstmt.setString(2, ssn);
    pstmt.setString(3, tel);
    pstmt.setString(4, balance);
    pstmt.setString(5, id);
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
<title>계좌 관리 프로그램</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>회원번호:</td>
            <td><input type="text" name="id" value="<%= idTmp %>"></td>
        </tr>
        <tr>
            <td>이름:</td>
            <td><input type="text" name="name" value="<%= nameTmp %>"></td>
        </tr>
        <tr>
            <td>비밀번호:</td>
            <td><input type="text" name="ssn" value="<%= ssnTmp %>"></td>
        </tr>
        <tr>
            <td>전화번호:</td>
            <td><input type="text" name="tel" id="tel" value="<%= telTmp %>" oninput="formatPhoneNumber(this)"></td>
        </tr>
        <tr>
            <td>잔액:</td>
            <td><input type="text" name="balance" value="<%= balanceTmp %>"></td>
        </tr>
    </table>
    <input type="submit" value="입력">
    <button type="submit" name="update" value="OK">수정</button>
    <button type="button" onclick="clearForm()">초기화</button>
</form>
<table>
    <tr>
        <th>회원번호</th><th>이름</th>
        <th>비밀번호</th><th>전화번호</th><th>잔액</th>
        <th>삭제</th>
    </tr>
<%
sql = "SELECT * FROM account";
pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
    idTmp = rs.getString("id");
    nameTmp = rs.getString("name");
    ssnTmp = rs.getString("ssn");
    telTmp = rs.getString("tel");
    balanceTmp = rs.getString("balance");
%>
<tr>
    <td><a href="?find=<%= idTmp %>"><%= idTmp %></a></td>
    <td><%= nameTmp %></td>
    <td><%= ssnTmp %></td>
    <td><%= telTmp %></td>
    <td><%= balanceTmp %></td>
    <td><button type="button" onclick="location.href='?delete=<%= idTmp %>'">삭제</button></td>
</tr>
<%
}
if (rs != null) rs.close();
if (pstmt != null) pstmt.close();
if (conn != null) conn.close();
%>
</table>
<script>
function formatPhoneNumber(input) {
    let value = input.value.replace(/\D/g, ''); // 숫자만 남기기
    let formattedValue = '';

    if (value.length > 0) {
        formattedValue = value.slice(0, 3);
    }
    if (value.length > 3) {
        formattedValue += '-' + value.slice(3, 7);
    }
    if (value.length > 7) {
        formattedValue += '-' + value.slice(7, 11);
    }

    input.value = formattedValue;
}

function clearForm() {
    document.querySelector('form').reset();
}
</script>
</body>
</html>