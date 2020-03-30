package com.kh.reserved.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.payment.model.service.PaymentService;

/**
 * Servlet implementation class MyCancelPayment
 */
@WebServlet("/MyCancelPayment.do")
public class MyCancelPayment extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservedNo = request.getParameter("reservedNo");
		
		int result = new PaymentService().cancelPayment(reservedNo);
		
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("msg", "예약이 취소되었습니다.");
		}else{
			session.setAttribute("msg", "예약 취소 실패!");
		}
		
		response.sendRedirect(request.getContextPath()+"/reserveDetail.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
