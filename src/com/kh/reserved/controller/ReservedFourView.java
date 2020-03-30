package com.kh.reserved.controller;

import static com.kh.common.isInteger.isInteger;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mem_code.model.service.MemCodeService;
import com.kh.mem_code.model.vo.MemCodes;
import com.kh.member.model.vo.Member;
import com.kh.member_grade.model.service.MemberGradeService;
import com.kh.member_grade.model.vo.MemberGrade;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.reserved.model.service.ReserveService;
import com.kh.screen.model.service.ScreenService;
import com.kh.still_image.model.service.StillImageService;

@WebServlet("/reservedFour.do")
public class ReservedFourView extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Integer userNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		
		
		// 기본값 세팅 말고 사용자에게 잘못된 요청임을 알림
		String sectionNo = request.getParameter("sectionNo");
		String theaterNo = request.getParameter("theaterNo");
		String movieNo = request.getParameter("movieNo");
		String screenNo = null;
		if(request.getParameter("screenNo") != null) {
			screenNo = request.getParameter("screenNo");
		}else {
			String roomNo = request.getParameter("roomNo");
			String screenTime = request.getParameter("screenTime"); //screenDate대용
			screenNo = new ScreenService().screenTheater(movieNo, roomNo, screenTime);
		}
		
		if(!isInteger(request.getParameter("sectionNo")) || !isInteger(request.getParameter("theaterNo"))
				|| !isInteger(request.getParameter("movieNo")) ||!isInteger(screenNo)) {
			request.getRequestDispatcher("views/reserved/reservedOneView.jsp").forward(request, response);
			return;
		}
		
		List<Integer> seats = new ReserveService().reservedSeats(screenNo); //이미 예매된 좌석정보
		MemCodes memCodes = new MemCodes(new MemCodeService().selectAll()); //MemCode별 금액
		String mainPoster = new StillImageService().selectMain(movieNo);	//메인포스터
		Movie m = new MovieService().selectL(Integer.parseInt(movieNo));
		MemberGrade loginMg = new MemberGradeService().selectGradeDiscount(userNo); // 로그인 회원의 등급+할인율
		
		request.setAttribute("movieNo", movieNo);
		request.setAttribute("screenNo", screenNo);
		request.setAttribute("ageLimit", m.getAgeLimit());
		request.setAttribute("sectionNo", sectionNo);
		request.setAttribute("memCode", memCodes.getMemCodes());
		request.setAttribute("mainPoster", mainPoster);
		request.setAttribute("seats", seats);
		request.setAttribute("loginMg", loginMg);
		request.setAttribute("adultCost", memCodes.findCostByType("ADULT"));
		request.setAttribute("youthCost", memCodes.findCostByType("YOUTH"));
		request.setAttribute("seniorCost", memCodes.findCostByType("SENIOR"));
		request.setAttribute("disabledCost", memCodes.findCostByType("DISABLED"));

		request.getRequestDispatcher("views/reserved/reservedFourView.jsp").forward(request, response);
	}
}
