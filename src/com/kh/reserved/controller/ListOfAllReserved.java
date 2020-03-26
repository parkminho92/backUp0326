package com.kh.reserved.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.reserved.model.dao.ListOfReserved;
import com.kh.reserved.model.service.ReserveService;

/**
 * Servlet implementation class ListOfAllReserved
 */
@WebServlet("/listAllReserved.do")
public class ListOfAllReserved extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ListOfReserved> lor = new ReserveService().ListOfAllReserved();
		
		request.setAttribute("lor", lor);
		
		request.getRequestDispatcher("views/reserved/adminReservedView.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
