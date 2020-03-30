package com.kh.screen.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.MovieCBS;
import com.kh.screen.model.service.ScreenService;
import com.kh.screen.model.vo.ScreenCBS;
import com.kh.section.model.service.SectionService;
import com.kh.section.model.vo.SectionCBS;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.TheaterCBS;

/**
 * Servlet implementation class ScreenWholeListServlet
 */
@WebServlet("/listScreen.sc")
public class ScreenWholeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScreenWholeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<SectionCBS> list = new SectionService().selectWholeSection();
		
		request.setAttribute("section", list);
		
		request.getRequestDispatcher("views/screen/screenWholeList.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
