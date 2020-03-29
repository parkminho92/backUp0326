package com.kh.reserved.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.payment.model.service.PaymentService;
import com.kh.payment.model.vo.Payment;
import com.kh.reserved.model.service.ReserveService;
import com.kh.reserved.model.vo.Reserved;
import com.kh.screen.model.dao.ScreenSelectDto;
import com.kh.screen.model.service.ScreenService;

/**
 * Servlet implementation class ReservedSixView
 */
@WebServlet("/reservedSix.do")
public class ReservedSixView extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Integer userNo = null;
		if((Member)session.getAttribute("loginUser")==null) {
			userNo = 1;
		}else {
			userNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		}
		
		Integer totalCost = Integer.parseInt(request.getParameter("totalCost"));
		String screenNo = request.getParameter("screenNo");
		String[] seatNo = request.getParameterValues("seatNo");
		String payMethod = request.getParameter("payMethod");
		
		Map<String, String> count = new HashMap<String, String>();
		count.put("adult",request.getParameter("adultCount"));
		count.put("youth",request.getParameter("youthCount"));
		count.put("senior",request.getParameter("seniorCount"));
		count.put("disabled",request.getParameter("disabledCount"));
		
		
		//결제 : 결제번호, 결제날짜sysdate, 결제방식, 결제금액, 환불여부(n), 환불날짜
		//예매 : 예매번호, 결제번호, 결제자번호, screenNo
		//예매된좌석 : 예매번호, 좌석번호
		//예매인원 : 예매번호, 분류, 숫자
		
		Integer result = new ReserveService().reserveMovie(payMethod, totalCost, userNo, screenNo, seatNo, count);
		
		//예매정보 가져오기
		Reserved reserveInfo = new ReserveService().reserveInfo(userNo);
		Payment paymentInfo = new PaymentService().paymentInfo(reserveInfo.getPaymentNo());
		ScreenSelectDto screenInfo = new ScreenService().reservedScreen(screenNo);

		
		request.setAttribute("reserveInfo", reserveInfo);
		request.setAttribute("paymentInfo", paymentInfo);
		request.setAttribute("screenInfo", screenInfo);
		
		request.getRequestDispatcher("views/reserved/reservedSixView.jsp").forward(request, response);
	
	}

}
