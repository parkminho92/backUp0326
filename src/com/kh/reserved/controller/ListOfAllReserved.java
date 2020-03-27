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
		
		//-- 페이징 처리 --
		int listCount;		//총게시글
		int currentPage; 	//현재페이지(요청페이지)
		int startPage;		//현재 페이지 하단에 보여지는 페이징 바의 시작
		int endPage;		// " 끝
		int maxPage;		//전체 페이지의 가장 마지막 페이지
		int pageLimit;		//한 페이지에 보여질 페이지 최대 갯수
		int boardLimit;		//한 페이지에 보여질 게시글 최대 갯수
		
		listCount = lor.size();
		currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		pageLimit = 5;
		boardLimit = 7;
		
		
		
		
		
		
		
		
		
		request.setAttribute("lor", lor);
		
		request.getRequestDispatcher("views/reserved/adminReservedView.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
