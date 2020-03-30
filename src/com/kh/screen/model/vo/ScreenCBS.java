package com.kh.screen.model.vo;

import java.sql.Timestamp;
import java.util.Date;

public class ScreenCBS {
	
	 /* SCREEN_NO */
	   private int screenNo;

	   /* ROOM_NO */
	   private int roomNo;

	   /* MOVIE_NO */
	   private int movieNo;

	   /* SCREEN_DATE */
	   private Date screenDate;
	   
	   private Timestamp screenDate1;
	   
	   private String name;
	   
	   private String title;

	public ScreenCBS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ScreenCBS(int screenNo) {
		super();
		this.screenNo = screenNo;
	}



	public ScreenCBS(Timestamp screenDate1, String name) {
		super();
		this.screenDate1 = screenDate1;
		this.name = name;
	}
	

	



	public ScreenCBS(int screenNo, Timestamp screenDate1, String name) {
		super();
		this.screenNo = screenNo;
		this.screenDate1 = screenDate1;
		this.name = name;
	}



	public ScreenCBS(int movieNo, String title) {
		super();
		this.movieNo = movieNo;
		this.title = title;
	}



	public ScreenCBS(int screenNo, int roomNo, int movieNo, Date screenDate, String name, String title) {
		super();
		this.screenNo = screenNo;
		this.roomNo = roomNo;
		this.movieNo = movieNo;
		this.screenDate = screenDate;
		this.name = name;
		this.title = title;
	}



	public ScreenCBS(int screenNo, int roomNo, int movieNo, Date screenDate) {
		super();
		this.screenNo = screenNo;
		this.roomNo = roomNo;
		this.movieNo = movieNo;
		this.screenDate = screenDate;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public Date getScreenDate() {
		return screenDate;
	}

	public void setScreenDate(Date screenDate) {
		this.screenDate = screenDate;
	}
	

	public Timestamp getScreenDate1() {
		return screenDate1;
	}



	public void setScreenDate1(Timestamp screenDate1) {
		this.screenDate1 = screenDate1;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "ScreenCBS [screenNo=" + screenNo + ", roomNo=" + roomNo + ", movieNo=" + movieNo + ", screenDate="
				+ screenDate + "]";
	}
	   
	   
	   
	
	
	

}
