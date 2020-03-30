package com.kh.borrow_room.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.borrow_room.model.service.BorrowRoomService;
import com.kh.borrow_room.model.vo.BorrowRoom;

/**
 * Servlet implementation class BrAdminDetailServlet
 */
@WebServlet("/adminDetail.br")
public class BrAdminDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrAdminDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int borrowNo = Integer.parseInt(request.getParameter("borrowNo"));
		
		BorrowRoom b = new BorrowRoomService().selectBorrowRoom(borrowNo);
		
		if(b != null) {
			request.setAttribute("b", b);
			request.getRequestDispatcher("views/borrow_room/adminDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "대관문의 상세조회 실패");
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
