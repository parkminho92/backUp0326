package com.kh.theater.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.room.model.vo.RoomCBS;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.TheaterCBS;

/**
 * Servlet implementation class DetailTheaterServlet
 */
@WebServlet("/detail.ta")
public class DetailTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailTheaterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int TheaterNo = Integer.parseInt(request.getParameter("TheaterNo"));
		
		TheaterCBS t = new TheaterService().selectTheater(TheaterNo);
		ArrayList<RoomCBS> r = new TheaterService().getRoomInfo(TheaterNo);
		
	
		
		if(t != null && r != null) {
				request.setAttribute("t", t);
				request.setAttribute("r", r);
				request.getRequestDispatcher("views/theater/theaterDetail.jsp").forward(request,response);
			
		}else {
			
			request.getSession().setAttribute("msg","영화관 상세조회 실패");
			response.sendRedirect("listTheater.ta");
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
