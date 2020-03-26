package com.kh.menubar.controller;

import java.util.ArrayList;
import java.util.List;



public class SectionDto {
	private Integer sectionNo;
	private String sectionName;
	
	public Integer getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public List<TheaterDto> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<TheaterDto> theaters) {
		this.theaters = theaters;
	}

	private List<TheaterDto> theaters;
	
	public SectionDto(Integer sectionNo, String sectionName) {
		this(sectionNo, sectionName, new ArrayList<>());
	}
	
	public SectionDto(Integer sectionNo, String sectionName, List<TheaterDto> theaters) {
		this.sectionNo = sectionNo;
		this.sectionName = sectionName;
		this.theaters = theaters;
	}
	
	public void addTheaterDto(TheaterDto theaterDto) {
		this.theaters.add(theaterDto);
	}
}

