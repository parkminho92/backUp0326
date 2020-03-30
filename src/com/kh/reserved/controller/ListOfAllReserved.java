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

		// 예약 총갯수 조회해오기
		int totalCount = new ReserveService().countReserved();
		// 하단 페이지 표시 정보
		PageInfo pageInfo = new PageInfo(totalCount, pageRequest);
		// 페이지 첫 게시글번호/마지막 번호로 페이지에 맞는 예약정보게시글 조회
		List<ListOfReserved> lor = new ReserveService().ListOfAllReserved(pageRequest);

		request.setAttribute("lor", lor);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher("views/reserved/adminReservedView.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
