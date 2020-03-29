package com.kh.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.menubar.controller.NewMoviesDto;
import com.kh.menubar.controller.TopMovieDto;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.MovieLHJ;

/**
 * Servlet implementation class MovieDetailServlet
 */
@WebServlet("/movieDetail.mo")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
		MovieLHJ m = new MovieService().selectList(movieNo);
		
		request.setAttribute("m", m);
		request.getRequestDispatcher("views/movie/MovieDetail.jsp").forward(request,response);
		
		List<TopMovieDto> tmdPoster = new MovieService().topFiveMovies(0);
		List<NewMoviesDto> nm = new MovieService().newMovies();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
