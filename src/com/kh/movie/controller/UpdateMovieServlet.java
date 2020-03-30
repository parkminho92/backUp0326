package com.kh.movie.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.MovieCBS;
import com.kh.still_image.model.vo.StillImageCBS;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateMovieServlet
 */
@WebServlet("/updateMovie.mv")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		
		
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String actor = request.getParameter("actor");
		int ageLimit = Integer.parseInt(request.getParameter("ageLimit"));
		int runtime = Integer.parseInt(request.getParameter("runtime"));
		String synopsis = request.getParameter("synopsis");
		
		String d = request.getParameter("onDate");
		Date onDate = Date.valueOf(d);
		
		MovieCBS m = new MovieCBS(movieNo, title, runtime, director, actor, ageLimit,  synopsis, onDate);

		
		String [] genre = request.getParameterValues("genre");
		
	
			

		
		int result = new MovieService().updateMovie(m,genre);
		
		if(result > 0) {
			
			
			response.sendRedirect("listComingMovie.mv");
			
		}else {
			
			
			request.getRequestDispatcher("/views/common/adminMenubar.jsp").forward(request,response);
			
			
			
			
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
