package com.kh.section.model.vo;

public class SectionCBS {

	
	private int sectionNo;
	private String name;
	
	public SectionCBS() {
		super();
		
	}

	public SectionCBS(int sectionNo, String name) {
		super();
		this.sectionNo = sectionNo;
		this.name = name;
	}

	public int getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SectionCBS [sectionNo=" + sectionNo + ", name=" + name + "]";
	}
	
	
	
	
}
