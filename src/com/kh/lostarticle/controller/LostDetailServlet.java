package com.kh.lostarticle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.lostarticle.model.service.LostService;
import com.kh.lostarticle.model.vo.Lostarticle;

/**
 * Servlet implementation class LostDetailServlet
 */
@WebServlet("/lostDetail.lo")
public class LostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LostDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int lost_No = Integer.parseInt(request.getParameter("lostNo"));
			
			Lostarticle l = new LostService().selectLostDetail(lost_No);
			
			if(l != null) {
				request.setAttribute("l", l);
				RequestDispatcher view = request.getRequestDispatcher("views/lostArticle/lostArticleDetail.jsp");
				view.forward(request, response);
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
