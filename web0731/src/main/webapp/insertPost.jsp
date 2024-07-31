<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.ServletException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 폼에서 전송된 데이터 읽기
    request.setCharacterEncoding("UTF-8"); // 요청 인코딩 설정

    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");

    // BoardDTO 객체 생성
    BoardDTO dto = new BoardDTO(0, writer, title, content, null, 0);

    // DAO 객체 생성 및 게시글 삽입
    BoardDAO dao = new BoardDAO();
    dao.insertBoard(dto);

    // 글 목록 페이지로 리다이렉트
    response.sendRedirect("list.jsp");
%>
