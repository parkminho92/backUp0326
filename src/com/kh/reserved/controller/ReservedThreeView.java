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
import com.kh.member.model.vo.Member;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Movies;
import com.kh.screen.model.service.ScreenService;
import com.kh.screen.model.vo.Screen;
import com.kh.section.model.service.SectionService;
import com.kh.section.model.vo.Section;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;

@WebServlet("/reservedThree.do")
public class ReservedThreeView extends HttpServlet {

 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 기본값 세팅 말고 사용자에게 잘못된 요청임을 알림
		String sectionNo = StringUtils.getValue(request.getParameter("sectionNo"));
		String theaterNo = request.getParameter("theaterNo");
		String movieNo = request.getParameter("movieNo");
		String lineUp = request.getParameter("lineUp");
		
		if(!isInteger(request.getParameter("sectionNo")) 
				|| !isInteger(request.getParameter("theaterNo"))
				|| !isInteger(request.getParameter("movieNo"))) {
			request.getRequestDispatcher("views/reserved/reservedOneView.jsp").forward(request, response);
			return;
		}
		
		if(StringUtils.isEmpty(lineUp) || !isInteger(request.getParameter("lineUp"))) {
			lineUp = "4";
		}
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		Movie findMovie = new MovieService().selectL(Integer.parseInt(movieNo));
		if (!findMovie.isAllowAge(loginUser.getBirth())) {
			session.setAttribute("msg", "예매하실 수 없는 영화입니다.");
					
			response.sendRedirect(
					request.getContextPath() + 
					String.format("/reservedTwo.do?sectionNo=%s&theaterNo=%s&movieNo=%s&lineUp=%s", sectionNo, theaterNo, movieNo, lineUp)
			);
			return;
		}
		
		String screenDate = request.getParameter("screenDate");
		
		if(StringUtils.isEmpty(screenDate)) {
			screenDate = DateUtils.getNowDateString();
		}
			
		List<Section> sList = new SectionService().selectAll();
		List<Theater> tList = new TheaterService().selectAllBySection(sectionNo);
		
		Movies movies = new Movies(new MovieService().selectScreen(theaterNo, screenDate, lineUp));
		List<Screen> scList = new ScreenService().selectScreen(theaterNo, movieNo, screenDate);
		
		request.setAttribute("screenDate", screenDate);
		request.setAttribute("sectionList", sList);
		request.setAttribute("theaterList", tList);
		request.setAttribute("movieList", movies.getMovies());
		request.setAttribute("currentMovieTitle", movies.findTitleByNo(Integer.parseInt(movieNo)));
		request.setAttribute("screenList", scList);
		request.getRequestDispatcher("views/reserved/reservedThreeView.jsp").forward(request, response);
	}

}
