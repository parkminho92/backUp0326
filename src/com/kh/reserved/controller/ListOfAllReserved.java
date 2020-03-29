package com.kh.reserved.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.StringUtils;
import com.kh.reserved.model.dao.ListOfReserved;
import com.kh.reserved.model.service.ReserveService;
import com.kh.reserved.model.vo.PageInfo;
import com.kh.reserved.model.vo.PageRequest;

/**
 * Servlet implementation class ListOfAllReserved
 */
@WebServlet("/listAllReserved.do")
public class ListOfAllReserved extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		String countPerPage = request.getParameter("countPerPage");
		PageRequest pageRequest = new PageRequest(currentPage, countPerPage);
				

		// 토탈 카운트 쿼리
		int totalCount = new ReserveService().countReserved();
		List<ListOfReserved> lor = new ReserveService().ListOfAllReserved(pageRequest);

		PageInfo pageInfo = new PageInfo(totalCount, pageRequest);

		request.setAttribute("lor", lor);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher("views/reserved/adminReservedView.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
