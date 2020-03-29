package com.kh.reserved.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.reserved.model.dao.ListOfReserved;
import com.kh.reserved.model.service.ReserveService;
import com.kh.reserved.model.vo.PageInfo;
import com.kh.reserved.model.vo.PageRequest;

/**
 * Servlet implementation class MyPageReservedDetail
 */
@WebServlet("/reserveDetail.do")
public class MyPageReservedDetail extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("currentPage");
		String countPerPage = request.getParameter("countPerPage");
		PageRequest pageRequest = new PageRequest(currentPage, countPerPage);
				
		HttpSession session = request.getSession();
		Integer userNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		
		// 1명의 토탈 카운트 쿼리
		int totalCount = new ReserveService().countReserved(userNo);
		List<ListOfReserved> lor = new ReserveService().ListOfAllReserved(pageRequest);

		PageInfo pageInfo = new PageInfo(totalCount, pageRequest);

		request.setAttribute("lor", lor);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher("views/reserved/adminReservedView.jsp").forward(request, response);
	
		request.getRequestDispatcher("views/reserved/myPageReservedDetail.jsp").forward(request, response);
	
	}

}
