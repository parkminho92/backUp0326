package com.kh.movie.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.service.MovieService;

/**
 * Servlet implementation class RerunMovieServlet
 */
@WebServlet("/rerunMovie.mv")
public class RerunMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RerunMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
		String d = request.getParameter("rerunDate");
		
		Date rerunDate = Date.valueOf(d);
		
		int result = new MovieService().rerunMovie(movieNo,rerunDate);
		
		if(result>0) {
			
			response.sendRedirect("listOffMovie.mv");
			
			
		}else {
			
			
			response.sendRedirect("listOffMovie.mv");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
