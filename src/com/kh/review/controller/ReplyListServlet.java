package com.kh.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;
import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.*;

/**
 * Servlet implementation class ReplyListServlet
 */
@WebServlet("/rlist.re")
public class ReplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		
			HttpSession session = request.getSession();
			int loginUserNo = 0;
			
			if((Member)session.getAttribute("loginUser") == null) {
				loginUserNo =1;
			}else {
				loginUserNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
			}
			
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
		ArrayList<ReviewLHJ> list = new ReviewService().selectReviewList(movieNo,loginUserNo);
 		
		response.setContentType("application/json; charset=UTF-8");
		request.setAttribute("list",list);
		
		
		Gson gson = new Gson();
		gson.toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
