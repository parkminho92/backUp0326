package com.kh.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.qna.model.service.QnaService;
import com.kh.qna.model.vo.*;

/**
 * Servlet implementation class QnaServlet
 */
@WebServlet("/qnaList.qa")
public class QnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int listCount;
		int currentPage;
		int startPage;
		int endPage;
		int maxPage;
		
		int pageLimit;
		int boardLimit;
		
		listCount = new QnaService().getListCount();
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage =(int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,startPage,endPage,maxPage,pageLimit,boardLimit);
	
		
		
		
		ArrayList<Qna> list = new QnaService().selectList(pi);
		
		request.setAttribute("list",list);
		request.setAttribute("pi",pi);
		RequestDispatcher view = request.getRequestDispatcher("views/qna/qnaListView.jsp");
		
		
		view.forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
