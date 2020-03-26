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
 * Servlet implementation class MemberChangeInfoServlet
 */
@WebServlet("/infoChange.me")
public class MemberChangeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChangeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("UTF-8");

				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String tel = request.getParameter("tel");
				String id = request.getParameter("id");

				//Member mem = new Member(userId, userName, phone, email, address, interest);

				// 비즈니스 로직을 처리하는 서비스 클래스에 해당 메소드 호출 및 전달값 전달
				//new MemberService().updateMember(mem);
				Member updateMem = new MemberService().updateMember(new Member(email, phone, tel, id));

				// 처리 결과에 맞춰 사용자가 보게될 응답화면 지정
				if(updateMem != null) { // 제대로 수정된 경우

					HttpSession session = request.getSession();
					session.setAttribute("loginUser", updateMem);

					request.setAttribute("msg", "회원 정보 수정이 완료되었습니다.");

					RequestDispatcher view = request.getRequestDispatcher("views/member/memberInfoChange.jsp");
					view.forward(request, response);

				}else { // 제대로 수정이 안되었을 경우

					request.setAttribute("msg", "회원 정보 수정 실패했습니다.");

					RequestDispatcher view = request.getRequestDispatcher("views/common/memberInfoChange.jsp");
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
