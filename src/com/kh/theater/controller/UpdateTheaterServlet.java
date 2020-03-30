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
 * Servlet implementation class UpdateTheaterServlet
 */
@WebServlet("/upDateTheater.ta")
public class UpdateTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTheaterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo1"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String parking = request.getParameter("parking");
		String transport = request.getParameter("transport");
		Double longitude = Double.parseDouble(request.getParameter("longitude"));
		Double latitude = Double.parseDouble(request.getParameter("latitude"));
		
		TheaterCBS t = new TheaterCBS(theaterNo,name,address,phone,parking,transport,longitude, latitude);
		
		int result = new TheaterService().updateTheater(t);
		
		if(result>0) {
			
			response.sendRedirect("detail.ta?theaterNo="+theaterNo);
			
		}else {
			
			response.sendRedirect("detail.ta?theaterNo="+theaterNo);
			
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
