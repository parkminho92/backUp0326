package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet("/findId.me")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("views/member/searchId.jsp");
		view.forward(request, response);

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		HttpSession session = request.getSession();
		String id = ((Member)session.getAttribute("loginUser")).getId();

		Member findIdMem = new MemberService().findId(id, name, email);


		if (findIdMem != null) { 

			session.setAttribute("findIdMem", findIdMem);
			request.setAttribute("msg", "비밀번호 변경이 완료되었습니다.");

			response.sendRedirect(request.getContextPath());


		} else {


			String message = "이름 또는 이메일을 다시 확인해 주세요";
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("history.back(-1);");
			out.println("</script>");


		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
