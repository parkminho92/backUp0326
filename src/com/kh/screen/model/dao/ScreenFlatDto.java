package com.kh.screen.model.dao;

import java.util.Date;


public class ScreenFlatDto {

	private Integer theaterNo;
	private Integer roomNo;
	private String roomName;
	private Integer screenNo;
	private Integer movieNo;
	private String title;
	private Integer ageLimit;
	private Date screenDate;
	
	public Integer getTheaterNo() {
		return theaterNo;
	}
	public void setTheaterNo(Integer theaterNo) {
		this.theaterNo = theaterNo;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(Integer screenNo) {
		this.screenNo = screenNo;
	}
	public Integer getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(Integer movieNo) {
		this.movieNo = movieNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(Integer ageLimit) {
		this.ageLimit = ageLimit;
	}
	public Date getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(Date screenDate) {
		this.screenDate = screenDate;
	}
	public ScreenFlatDto(Integer theaterNo, Integer roomNo, String roomName, Integer screenNo, Integer movieNo,
			String title, Integer ageLimit, Date screenDate) {
		super();
		this.theaterNo = theaterNo;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.screenNo = screenNo;
		this.movieNo = movieNo;
		this.title = title;
		this.ageLimit = ageLimit;
		this.screenDate = screenDate;
	}
	
}
