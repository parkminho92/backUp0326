package com.kh.theater.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.TheaterCBS;

/**
 * Servlet implementation class InsertTheaterServlet
 */
@WebServlet("/insertTheater.ta")
public class InsertTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTheaterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("tName");
		String address = request.getParameter("tAddress");
		int roomCount = Integer.parseInt(request.getParameter("roomCount"));
		String phone = request.getParameter("tel");
		String parking = request.getParameter("parkingInfo");
		String transport = request.getParameter("transInfo");
		Double longitude = Double.parseDouble(request.getParameter("longitude"));
		Double latitude = Double.parseDouble(request.getParameter("latitude"));
		int sectionNo = Integer.parseInt(request.getParameter("sectionNo"));
		
		TheaterCBS t = new TheaterCBS(name, address, phone, roomCount, transport, parking, longitude, latitude, sectionNo);
		
		int result = new TheaterService().insertTheater(t);
		
		if(result>0) {
			
			response.sendRedirect("listTheater.ta");
			
		}else {
			
			request.setAttribute("msg", "영화관 등록에 실패했습니다.");
			request.getRequestDispatcher("views/theater/theaterInsertForm.jsp").forward(request,response);
			
			
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
