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
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
		 
		
		 String id = request.getParameter("id"); 
		 String pwd = request.getParameter("userPwd"); 
		 String name = request.getParameter("name");
		 String birth = request.getParameter("birth"); 
		 String email = request.getParameter("email");
		 String phone = request.getParameter("phone"); 
		 String tel = request.getParameter("tel");
		 String gender = request.getParameter("gender");
		 
		 Member mem = new Member(id, pwd, name, email, phone, tel, gender);
		 
		 int result = new MemberService().insertMember(mem, birth);
		  
		 if(result > 0) {

		 HttpSession session = request.getSession(); 
		 session.setAttribute("msg", "회원 가입 성공!");
		  
		 response.sendRedirect(request.getContextPath());
		 
		 
		  
		 }else {
		  
			 request.setAttribute("msg", "회원가입 실패!");
			  
			 RequestDispatcher view = request.getRequestDispatcher("views/member/memberEnrollForm.jsp");
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
