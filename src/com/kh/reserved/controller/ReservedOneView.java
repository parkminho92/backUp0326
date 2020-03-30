package com.kh.reserved.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.section.model.service.SectionService;
import com.kh.section.model.vo.Section;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;
import static com.kh.common.isInteger.*;

@WebServlet("/reservedOne.do")
public class ReservedOneView extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<Section> sList = new SectionService().selectAll();
		
		String sectionNo = "1";
		if(isInteger(request.getParameter("sectionNo"))) {
			sectionNo = request.getParameter("sectionNo");
		}
		List<Theater> tList = new TheaterService().selectAllBySection(sectionNo);
		
		request.setAttribute("sectionList", sList);
		request.setAttribute("theaterList", tList);
		request.getRequestDispatcher("views/reserved/reservedOneView.jsp").forward(request, response);
	
	}


}
