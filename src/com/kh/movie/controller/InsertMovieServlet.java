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
 * Servlet implementation class InsertMovieServlet
 */
@WebServlet("/insertMovie.mv")
public class InsertMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			
			String savePath = resources + "\\poster_upfiles\\";
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
			
			String title = multiRequest.getParameter("title");
			String director = multiRequest.getParameter("director");
			String actor = multiRequest.getParameter("actor");
			
			
			String d = multiRequest.getParameter("onDate");
			
			Date onDate = Date.valueOf(d);
			
			
			int runtime = Integer.parseInt(multiRequest.getParameter("runtime"));
			int ageLimit = Integer.parseInt(multiRequest.getParameter("ageLimit"));
			String synopsis = multiRequest.getParameter("synopsis");
			
			String[] genres = multiRequest.getParameterValues("genre");
			
			MovieCBS mv = new MovieCBS(title,director,actor,onDate,runtime,ageLimit,synopsis);
			
			
			ArrayList<StillImageCBS> list = new ArrayList<>();
			
			for(int i=1;i<6;i++) {
				
				String name ="file" + i;
				
				if(multiRequest.getOriginalFileName(name)!=null) {
					
					String originName = multiRequest.getOriginalFileName(name);
					String changeName = multiRequest.getFilesystemName(name);
					
					
					StillImageCBS si = new StillImageCBS();
					si.setOriginName(originName);
					si.setModifyName(changeName);
					si.setSavePath(savePath);
					list.add(si);
					
				}
				
				
			}
			
			int result = new MovieService().insertMovie(mv,genres,list);
			
			
			
			if(result==0) {
				
				for(int i=0;i<list.size();i++) {
					File deleteFile = new File(savePath + list.get(i).getModifyName());
					
					deleteFile.delete();
				}
				request.setAttribute("msg", "영화등록에 실패했습니다..");
				request.getRequestDispatcher("/views/movie/insertMovieForm.jsp").forward(request, response);
			
			}else {
					request.getSession().setAttribute("msg", "영화등록에 성공했습니다.");
					response.sendRedirect("listComingMovie.mv");
				
				
				
				
			}
			
			
			
			
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
