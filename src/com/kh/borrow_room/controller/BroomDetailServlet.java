package com.kh.borrow_room.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.borrow_room.model.service.BroomService;
import com.kh.borrow_room.model.vo.BorrowRoom;

/**
 * Servlet implementation class BroomDetailServlet
 */
@WebServlet("/broomDetail.br")
public class BroomDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BroomDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int borrowRoomNo = Integer.parseInt(request.getParameter("borrowRoomNo"));
		
		BorrowRoom b = new BroomService().selectBroomDetail(borrowRoomNo);
		
		if(b != null) {
			
			request.setAttribute("b", b);
			RequestDispatcher view = request.getRequestDispatcher("views/borrow_room/broomDetail.jsp");
			
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
