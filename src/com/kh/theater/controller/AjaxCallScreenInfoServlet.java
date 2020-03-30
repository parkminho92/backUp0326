package com.kh.theater.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.screen.model.service.ScreenService;
import com.kh.screen.model.vo.ScreenCBS;

/**
 * Servlet implementation class AjaxCallScreenInfoServlet
 */
@WebServlet("/callScreenInfo.sc")
public class AjaxCallScreenInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCallScreenInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int movieNo = Integer.parseInt(request.getParameter("movieNo"));
	int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		
		ArrayList<ScreenCBS> list = new	ScreenService().selectWholeScreenInfo(movieNo, theaterNo);
		
		response.setContentType("application/json; charset=utf-8");
		
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy년 MM월 dd일 HH:mm:dd").create();
		
		gson.toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
