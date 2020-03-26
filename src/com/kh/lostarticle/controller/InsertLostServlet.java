package com.kh.lostarticle.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.lostarticle.model.service.LostService;
import com.kh.lostarticle.model.vo.Lostarticle;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class InsertLostServlet
 */
@WebServlet("/insertLost.lo")
public class InsertLostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int loginUserNo = 0;
		
		if((Member)session.getAttribute("loginUser") == null) {
			loginUserNo = 1;
		} else {
			loginUserNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		}
		
		String Name = request.getParameter("lName");
		String Phone = request.getParameter("lPhone");
		String Email = request.getParameter("lEmail");
		String Place = request.getParameter("lPlace");
		String Date = request.getParameter("lDate");
		String checkPwd = request.getParameter("checkPwd");
		String SecretPwd = request.getParameter("lSecretPwd");
		String Title = request.getParameter("Title");
		String Content = request.getParameter("lContent");
		
		Lostarticle l = new Lostarticle();
		
		l.setName(Name);
		l.setPhone(Phone);
		l.setEmail(Email);
		l.setPlace(Place);
		l.setSecretStatus(checkPwd);
		l.setSecretPwd(SecretPwd);
		l.setTitle(Title);
		l.setContent(Content);
		
		int result = new LostService().insertLost(l, loginUserNo, Date);
		
		if(result > 0) {
			response.sendRedirect("lost.lo");
		
		} else {
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
