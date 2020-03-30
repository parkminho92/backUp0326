package com.kh.screen.model.controller;

import java.io.IOException;
import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.screen.model.service.ScreenService;

/**
 * Servlet implementation class InsertScreenInfoServlet
 */
@WebServlet("/insertScreen.sc")
public class InsertScreenInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertScreenInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		
		
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
		String rDate = request.getParameter("rDate");
		
		String [] rtime = request.getParameterValues("rTime");
		
		String []sDate = new String [rtime.length];
		for(int i=0;i<rtime.length;i++) {
			
			sDate[i] = rDate + " " + rtime[i];
			
		
			
		
			
			System.out.println(sDate[i]);
		}
		
		int result = new ScreenService().insertScreenInfo(roomNo, movieNo, sDate);
		
		
		if(result>0) {
			
		
			response.sendRedirect("listTheater.ta");
		}else {
			
			
			request.getRequestDispatcher("views/common/adminMenubar.jsp").forward(request, response);
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
