<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
p

    request.setCharacterEncoding("UTF-8");

    String num = request.getParameter("num");
    String writer = request.getParameter("writer");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    BoardDTO dto = new BoardDTO(Integer.parseInt(num), writer, title, content, null, 0);
    AccountDAO dao = new AccountDAO();
    dao.updateBoard(dto);

    response.sendRedirect("list.jsp");
%>
