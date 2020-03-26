package com.kh.member.controller;

import java.io.IOException;

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
 * Servlet implementation class MemberUpdatePwdServlet
 */
@WebServlet("/updatePwd.me")
public class MemberUpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userPwd = request.getParameter("Pwd");
		String newPwd = request.getParameter("newPwd");



		HttpSession session = request.getSession();
		String id = ((Member)session.getAttribute("loginUser")).getId();

		int result = new MemberService().updatePwdMember(id, userPwd, newPwd);

		if(result>0) {
			request.setAttribute("msg", "비밀번호 변경이 완료되었습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/member/updatePwdForm.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("msg", "비밀번호 변경에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/member/updatePwdForm.jsp");
			view.forward(request, response);
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