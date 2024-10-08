
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%


    String num = request.getParameter("num");
    AccountDAO dao = new AccountDAO();
    BoardDTO dto = dao.getOne(Integer.parseInt(num));

    if (dto == null) {
        out.println("게시글을 찾을 수 없습니다.");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <style>
        table { width:680px; text-align:center; }
        th { background-color:cyan; }
        input[type=text], textarea { width:100%; }
    </style>
</head>
<body>
<form method="post" action="updatePost.jsp">
    <input type="hidden" name="num" value="<%= dto.getNum() %>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title" maxlength="80" value="<%= dto.getTitle() %>"></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20" value="<%= dto.getWriter() %>"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"><%= dto.getContent() %></textarea></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="수정">
    <input type="button" value="취소" onclick="history.back()">
</form>
</body>
</html>
