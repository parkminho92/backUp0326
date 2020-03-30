package com.kh.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.ReviewLHJ;

/**
 * Servlet implementation class ReplyInsertServlet
 */
@WebServlet("/insertReply.re")
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();	
		int loginUserNo = 1;
		
		if((Member)session.getAttribute("loginUser") == null) {
			loginUserNo = 1;
		} else {
			loginUserNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		}
		
		String content = request.getParameter("content");
		int count = Integer.parseInt(request.getParameter("count"));
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
		ReviewLHJ r = new ReviewLHJ();
		
		r.setReviewRating(count);
		r.setReviewText(content);
		r.setMovieNo(movieNo);
		
		int result = new ReviewService().insertReview(r,loginUserNo);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		
		System.out.println(r);
		System.out.println(loginUserNo);
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
