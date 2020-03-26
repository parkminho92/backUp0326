package com.kh.menubar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.section.model.dao.SectionFlatDto;
import com.kh.section.model.service.SectionService;


@WebServlet("/menubarServlet")
public class MenuBarServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Flat DTO로 조회 
		List<SectionFlatDto> sectionFlat = new SectionService().selectSectionDto();
		
		Map<Integer, SectionDto> sectionMap = new HashMap<>();
		// 데이터 변환
		for(SectionFlatDto flatDto: sectionFlat) {
			SectionDto sectionDto  = null;
			if (sectionMap.get(flatDto.getSectionNo()) == null) {
				// 처음 생성 하는 지역
				sectionDto = new SectionDto(flatDto.getSectionNo(), flatDto.getSectionName());
				sectionMap.put(flatDto.getSectionNo(), sectionDto);
			} else {
				// 이미 생성된 지역
				sectionDto = sectionMap.get(flatDto.getSectionNo());
			}
			TheaterDto theaterDto = new TheaterDto(flatDto.getTheaterNo(), flatDto.getTheaterName());
			sectionDto.addTheaterDto(theaterDto);
		}
		List<SectionDto> sections = new ArrayList<>(sectionMap.values());
		
		request.setAttribute("sections", sections);
		request.getRequestDispatcher("views/common/menubar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
