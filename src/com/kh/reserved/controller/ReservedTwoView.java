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

import com.kh.common.DateUtils;
import com.kh.common.StringUtils;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.section.model.service.SectionService;
import com.kh.section.model.vo.Section;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;

@WebServlet("/reservedTwo.do")
public class ReservedTwoView extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 기본값 세팅 말고 사용자에게 잘못된 요청임을 알림
		String sectionNo = request.getParameter("sectionNo");
		String theaterNo = request.getParameter("theaterNo");
		String screenDate = request.getParameter("screenDate");
		
		if(StringUtils.isEmpty(screenDate)) {
			screenDate = DateUtils.getNowDateString();
		}

		String lineUp = request.getParameter("lineUp");
		if(StringUtils.isEmpty(lineUp) || !isInteger(request.getParameter("lineUp"))) {
			lineUp = "4";
		}
		
		if(!isInteger(request.getParameter("sectionNo")) || !isInteger(request.getParameter("theaterNo"))) {
			request.getRequestDispatcher("views/reserved/reservedOneView.jsp").forward(request, response);
			return;
		}
		
		List<Section> sList = new SectionService().selectAll();
		List<Theater> tList = new TheaterService().selectAllBySection(sectionNo);
		List<Movie> mList = new MovieService().selectScreen(theaterNo, screenDate, lineUp);
		
		request.setAttribute("sectionList", sList);
		request.setAttribute("theaterList", tList);
		request.setAttribute("movieList", mList);
		request.getRequestDispatcher("views/reserved/reservedTwoView.jsp").forward(request, response);
	
	}


}
