package com.kh.borrow_room.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.borrow_room.model.service.BroomService;
import com.kh.borrow_room.model.vo.BorrowRoom;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class InsertBroomServlet
 */
@WebServlet("/insertBroom.br")
public class InsertBroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBroomServlet() {
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
				loginUserNo =1;
			}else {
				loginUserNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
			}
			
			
			String bemail = request.getParameter("bemail");
			
			String yno = request.getParameter("yno");
			int yNo;
			if(yno==null) {
				yNo = 0;
			}else {
				yNo=Integer.parseInt(request.getParameter("yno"));
			}
			
			String ano = request.getParameter("ano");
			int aNo;
			if(ano==null) {
				aNo = 0;
			}else {
				aNo=Integer.parseInt(request.getParameter("ano"));
			}
			
			String sno = request.getParameter("sno");
			int sNo;
			if(sno==null) {
				sNo = 0;
			}else {
				sNo=Integer.parseInt(request.getParameter("sno"));
			}
			
			String dno = request.getParameter("dno");
			int dNo;
			if(dno==null) {
				dNo = 0;
			}else {
				dNo=Integer.parseInt(request.getParameter("dno"));
			}
			
			String bdate = request.getParameter("bdate");
			String checkPwd = request.getParameter("checkPwd");
			String secretPwd = request.getParameter("secretPwd");
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
			
			BorrowRoom b = new BorrowRoom();
			b.setEmail(bemail);
			b.setYouthCount(yNo);
			b.setAdultCount(aNo);
			b.setSeniorCount(sNo);
			b.setDisabledCount(dNo);
			b.setSecretStatus(checkPwd);
			b.setSecretPwd(secretPwd);
			b.setTitle(btitle);
			b.setContent(bcontent);
			
			int result = new BroomService().insertBroom(b ,loginUserNo, bdate);
		
			if(result > 0) {
				response.sendRedirect("bRoom.br");
			} else {
				request.setAttribute("msg", "게시판 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
