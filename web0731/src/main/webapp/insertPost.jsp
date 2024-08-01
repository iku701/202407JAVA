<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.ServletException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
p

    request.setCharacterEncoding("UTF-8"); 

    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");

    BoardDTO dto = new BoardDTO(0, writer, title, content, null, 0);

    AccountDAO dao = new AccountDAO();
    dao.insertBoard(dto);

    response.sendRedirect("list.jsp");
%>
