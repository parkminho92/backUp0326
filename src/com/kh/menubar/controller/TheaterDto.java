package com.kh.menubar.controller;


public class TheaterDto {
	private Integer theaterNo;
	private String theaterName;
	
	public TheaterDto(Integer theaterNo, String theaterName) {
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
	}

	public void setTheaterNo(Integer theaterNo) {
		this.theaterNo = theaterNo;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Integer getTheaterNo() {
		return theaterNo;
	}

	public String getTheaterName() {
		return theaterName;
	}
	
}
