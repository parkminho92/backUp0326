package com.kh.lostarticle.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.lostarticle.model.service.LostarticleService;
import com.kh.lostarticle.model.vo.Lostarticle;

/**
 * Servlet implementation class LostDetailServlet
 */
@WebServlet("/adminDetail.lo")
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
		
		int lostNo = Integer.parseInt(request.getParameter("lostNo"));
			
		Lostarticle l = new LostarticleService().selectAdminLost(lostNo);
			
		if(l != null) {
			request.setAttribute("l", l);
			request.getRequestDispatcher("views/lostArticle/adminDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "분실물문의 상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
