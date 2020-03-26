package com.kh.theater.controller;

import static com.kh.common.isInteger.isInteger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.DateUtils;
import com.kh.common.StringUtils;
import com.kh.screen.model.dao.ScreenFlatDto;
import com.kh.screen.model.service.ScreenService;
import com.kh.theater.model.dao.MovieDto;
import com.kh.theater.model.dao.RoomDto;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;


@WebServlet("/detailView.th")
public class TheaterViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String theaterNo = request.getParameter("theaterNo");
		String screenDate = request.getParameter("screenDate");
		if(StringUtils.isEmpty(screenDate)) {
			screenDate = DateUtils.getNowDateString();
		}
		if(!isInteger(request.getParameter("theaterNo"))) {
			request.getRequestDispatcher("").forward(request, response);
			return;
		}
		
		//영화관 상세정보
		Theater t = new TheaterService().selectTheater(theaterNo);
		
		//ScreenFlatDto 조회
		List<ScreenFlatDto> sList = new ScreenService().selectScreen(theaterNo, screenDate);
		Map<Integer, MovieDto> movieMap = new HashMap<>();
		
		for(ScreenFlatDto flatDto : sList) {
			MovieDto movieDto = null;
			if(movieMap.get(flatDto.getMovieNo())==null) {
				movieDto = new MovieDto(flatDto.getMovieNo(), flatDto.getTitle(), flatDto.getAgeLimit());
				movieMap.put(flatDto.getMovieNo(), movieDto);
			} else {
				movieDto = movieMap.get(flatDto.getMovieNo());
			}
			RoomDto roomDto = new RoomDto(flatDto.getRoomNo(), flatDto.getRoomName(), flatDto.getScreenDate());
			movieDto.addRoomDto(roomDto);
		}
		List<MovieDto> movies = new ArrayList<>(movieMap.values());
		
		request.setAttribute("theaterNo", theaterNo);
		request.setAttribute("screenDate", screenDate);
		request.setAttribute("selectTheater", t);
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("views/theater/theaterView.jsp").forward(request, response);
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
