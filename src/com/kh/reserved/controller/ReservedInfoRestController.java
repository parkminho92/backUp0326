package com.kh.reserved.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.common.StringUtils;
import com.kh.reserved.model.dao.ListOfReserved;
import com.kh.reserved.model.service.ReserveService;

/**
 * Servlet implementation class ReservedInfoRestController
 */
@WebServlet("/reservedInfo.do")
public class ReservedInfoRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservedInfoRestController() {
        super();
    }

    
//    class Result<T> {
//    	int status;
//    	String message;
//    	T data;
//    	
//    	public Result(int status, String message) {
//    		this(status, message, null);
//    	}
//    	
//		public Result(int status, String message, T data) {
//			this.status = status;
//			this.message = message;
//			this.data = data;
//		}
//    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;");
		PrintWriter writer = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String reservedInfoId = request.getParameter("reservedInfoId");
		
		if (StringUtils.isEmpty(reservedInfoId) || !StringUtils.isInteger(reservedInfoId))  {
			//  에러 메시지 처리
			// {"message": "fail"};
//			Result<String> result = new Result<>(400, "fail");
			writer.write("{\"message\": \"fail\"}");
//			writer.write(mapper.writeValueAsString(result));
			writer.flush();
			return;
		}
		
		ListOfReserved reservedInfo = new ReserveService().findReservedInfo(Integer.parseInt(reservedInfoId));
		String jsonString = mapper.writeValueAsString(reservedInfo);
		writer.write(jsonString);
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
