package com.kh.screen.model.dao;

import java.util.Date;

public class ScreenSelectDto {
	private Integer screenNo;
	private Integer theaterNo;
	private String theaterName;
	private Integer roomNo;
	private String roomName;
	private Integer movieNo;
	private String movieTitle;
	private Integer ageLimit;
	private Date screenDate;
	private Integer mainPoster;
	private String modifyName;
	
	public ScreenSelectDto() {
	
	};
	
	
	public Integer getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(Integer screenNo) {
		this.screenNo = screenNo;
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
	public Integer getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(Integer movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
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
	public Integer getMainPoster() {
		return mainPoster;
	}
	public void setMainPoster(Integer mainPoster) {
		this.mainPoster = mainPoster;
	}
	public String getModifyName() {
		return modifyName;
	}
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	public ScreenSelectDto(Integer screenNo, Integer theaterNo, String theaterName, Integer roomNo, String roomName,
			Integer movieNo, String movieTitle, Integer ageLimit, Date screenDate, Integer mainPoster,
			String modifyName) {
		super();
		this.screenNo = screenNo;
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.ageLimit = ageLimit;
		this.screenDate = screenDate;
		this.mainPoster = mainPoster;
		this.modifyName = modifyName;
	}

	
}
