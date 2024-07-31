<%@page import="java.util.List"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String delete = request.getParameter("delete");

    if (delete != null) {
        int num = Integer.parseInt(delete);
        BoardDAO dao = new BoardDAO();
        dao.deleteBoard(num);
        response.sendRedirect("list.jsp"); 
        return; 
    }

    BoardDAO dao = new BoardDAO();
    List<BoardDTO> list = dao.getBoardList();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th { background-color:cyan; }
        .num { width: 80px; }
        .title { width:230px; }
        .writer { width:100px; }
        .regtime { width:180px; }
        .delete { width: 80px; }
        a:link { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover { text-decoration:none; color:red; }
    </style>
</head>
<body>
<table>
    <tr>
        <th class="num">번호</th>
        <th class="title">제목</th>
        <th class="writer">작성자</th>
        <th class="regtime">작성일시</th>
        <th class="delete">삭제</th>
    </tr>
<%
    for (BoardDTO dto : list) {
        String numTmp = String.valueOf(dto.getNum());
        String titleTmp = dto.getTitle();
        String writerTmp = dto.getWriter();
        String regtimeTmp = dto.getRegtime();
%>
    <tr>
        <td><a href="view.jsp?num=<%= numTmp %>"><%= numTmp %></a></td>
        <td style="text-align:left;"><%= titleTmp %></td>
        <td><%= writerTmp %></td>
        <td><%= regtimeTmp %></td>
        <td>
            <button type="button" onclick="location.href='delete.jsp?delete=<%= numTmp %>'">삭제</button>
        </td>
    </tr>
<%
    }
%>
</table>
<br>
<input type="button" value="돌아가기" onclick="location.href='list.jsp'">
</body>
</html>
