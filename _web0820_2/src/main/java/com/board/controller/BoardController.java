package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.db.*;
import com.board.service.BoardService;

@WebServlet("/")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = null;

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		// 주어진 URL에 따라 지정된 동작 수행
		if (com.equals("/")) {
			view = "main.jsp";
		} else if (com.equals("/list")) {
			String tmp = request.getParameter("page");
			int pageNo = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 1;

			request.setAttribute("msgList", new BoardService().getMsgList(pageNo));
			request.setAttribute("pgnList", new BoardService().getPagination(pageNo));
			System.out.println(new BoardService().getPagination(pageNo));
			view = "list.jsp";

		} else if (com.equals("/view")) {
			int num = Integer.parseInt(request.getParameter("num"));
			request.setAttribute("msg", new BoardService().getMsg(num));
			view = "view.jsp";

		} else if (com.equals("/write")) {
			String tmp = request.getParameter("num");
			int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;

			BoardDto dto = new BoardDto();
			String action = "insert";

			if (num > 0) {
				dto = new BoardService().getMsgForWrite(num);
				action = "update?num=" + num;
			}

			request.setAttribute("msg", dto);
			request.setAttribute("action", action);
			view = "write.jsp";

		} else if (com.equals("/insert")) {
			request.setCharacterEncoding("utf-8");
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			try {
				new BoardService().writeMsg(writer, title, content);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}

		} else if (com.equals("/update")) {
			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("num"));
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			try {
				new BoardService().updateMsg(writer, title, content, num);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}

		} else if (com.equals("/delete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			new BoardService().deleteMsg(num);
			view = "redirect:list";

		} else if (com.equals("/loginForm")) {
			view = "/sign-in/loginForm.jsp";

		} else if (com.equals("/login")) {
			request.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email + ", " + password);

			MemberDto memberDto = new MemberDto(0, "", email, password, "");
			MemberDao memberDao = new MemberDao();
			int login = memberDao.isMember(memberDto);

			if (login == 1) {
				System.out.println("로그인 성공!");
				memberDto = memberDao.findMember(memberDto);
				System.out.println(memberDto);
				HttpSession session = request.getSession();
				session.setAttribute("customInfo", memberDto);
				request.setAttribute("userLoggedIn", true);

				// 로그인 성공 메시지 설정
				request.setAttribute("successMessage", "로그인에 성공했습니다!");

				view = "main.jsp"; // 로그인 성공 후 메인 페이지로 이동

			} else {
				System.out.println("로그인 실패!");
				request.setAttribute("errorMessage", "로그인에 실패했습니다. 다시 시도하세요.");
				view = "/sign-in/loginForm.jsp"; // 로그인 실패 시 로그인 폼으로 돌아가기
			}
		} else if (com.equals("/")) {
            HttpSession session = request.getSession();
            session.invalidate();  // 세션 무효화
            request.setAttribute("successMessage", "성공적으로 로그아웃 되었습니다.");
            view = "main.jsp";  // 로그아웃 후 메인 페이지로 이동

        } else if (com.equals("/joinForm")) {
            view = "/sign-in/joinForm.jsp"; // 회원가입 폼으로 이동
        } 
        else if (com.equals("/join")) {
        	// 회원가입 처리
        	request.setCharacterEncoding("utf-8");
        	String name = request.getParameter("name");
        	String email = request.getParameter("email");
        	String password = request.getParameter("password");

        	MemberDto memberDto = new MemberDto(0, name, email, password, null);
        	MemberDao memberDao = new MemberDao();

        	try {
        		memberDao.insertMember(memberDto);
        		request.setAttribute("successMessage", "회원가입에 성공했습니다! 로그인 해주세요.");
        		view = "/sign-in/loginForm.jsp"; // 회원가입 성공 후 로그인 페이지로 이동

        	} catch (Exception e) {
        		request.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도하세요.");
        		view = "/sign-in/joinForm.jsp"; // 회원가입 실패 시 다시 회원가입 폼으로 돌아가기
        	}
        }
		
		
		
		
		else {
            view = "error404.jsp";  // 예외적인 URL 처리 (404 페이지로 리디렉션)
        }

		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
