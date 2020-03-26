package com.kh.section.model.dao;

public class SectionFlatDto {

	private Integer sectionNo;
	private String sectionName;
	private Integer theaterNo;
	private String theaterName;
	
	
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

	public Integer getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(Integer theaterNo) {
		this.theaterNo = theaterNo;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public SectionFlatDto(Integer sectionNo, String sectionName, Integer theaterNo, String theaterName) {
		this.sectionNo = sectionNo;
		this.sectionName = sectionName;
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
	}
}