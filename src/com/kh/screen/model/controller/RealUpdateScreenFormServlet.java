package com.kh.screen.model.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.screen.model.service.ScreenService;
import com.kh.screen.model.vo.ScreenCBS;

/**
 * Servlet implementation class RealUpdateScreenFormServlet
 */
@WebServlet("/realUpdateScreen.sc")
public class RealUpdateScreenFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealUpdateScreenFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));
		String screenDate = request.getParameter("screenDate");
		
		

		
		int result = new ScreenService().searchThisScreenInfo(theaterNo,movieNo,screenNo,screenDate);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
