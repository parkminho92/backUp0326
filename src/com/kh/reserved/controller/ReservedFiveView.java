package com.kh.reserved.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.screen.model.dao.ScreenSelectDto;
import com.kh.screen.model.service.ScreenService;

/**
 * Servlet implementation class ReservedFiveViewServelet
 */
@WebServlet("/reservedFive.do")
public class ReservedFiveView extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String screenNo = request.getParameter("screenNo");
		String totalCost = request.getParameter("totalCost");
		String[] seatNo = request.getParameterValues("seatNo");
		String adultCount = request.getParameter("adult");
		String youthCount = request.getParameter("youth");
		String seniorCount = request.getParameter("senior");
		String disabledCount = request.getParameter("disabled");
		
		ScreenSelectDto screenInfo = new ScreenService().reservedScreen(screenNo);
	
		
		request.setAttribute("seatNo", seatNo);
		request.setAttribute("screenInfo", screenInfo);

		request.getRequestDispatcher("views/reserved/reservedFiveView.jsp").forward(request, response);
	}


}
