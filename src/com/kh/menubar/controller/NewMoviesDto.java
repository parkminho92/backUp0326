package com.kh.menubar.controller;

import java.util.Date;

public class NewMoviesDto {

	private Integer movieNo;
	private Date onDate;
	private Integer ageLimit;
	private String title;
	private String modifyName;
	
	public Integer getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(Integer movieNo) {
		this.movieNo = movieNo;
	}
	public Date getOnDate() {
		return onDate;
	}
	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}
	public Integer getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(Integer ageLimit) {
		this.ageLimit = ageLimit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getModifyName() {
		return modifyName;
	}
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	
	public NewMoviesDto(Integer movieNo, Date onDate, Integer ageLimit, String title, String modifyName) {
		super();
		this.movieNo = movieNo;
		this.onDate = onDate;
		this.ageLimit = ageLimit;
		this.title = title;
		this.modifyName = modifyName;
	}
	
	
}
