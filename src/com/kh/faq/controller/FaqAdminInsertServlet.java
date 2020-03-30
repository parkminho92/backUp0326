package com.kh.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.faq.model.service.FaqService;
import com.kh.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqInsertServlet
 */
@WebServlet("/adminInsert.fq")
public class FaqAdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqAdminInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		Faq f = new Faq();
		f.setType(type);
		f.setQuestion(question);
		f.setAnswer(answer);
		
		int result = new FaqService().insertFaq(f);
		
		if(result > 0) {
			response.sendRedirect("adminList.fq");
		}else {
			request.setAttribute("msg", "작성 실패");
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
