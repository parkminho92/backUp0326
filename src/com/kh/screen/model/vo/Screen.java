package com.kh.screen.model.vo;

import java.util.Date;


public class Screen {
   /* SCREEN_NO */
   private int screenNo;

   /* ROOM_NO */
   private int roomNo;

   /* MOVIE_NO */
   private int movieNo;

   /* SCREEN_DATE */
   private Date screenDate;
   
   public Screen() {
	   
   }

public Screen(int screenNo, int roomNo, int movieNo, Date screenDate) {
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

@Override
public String toString() {
	return "Screen [screenNo=" + screenNo + ", roomNo=" + roomNo + ", movieNo=" + movieNo + ", screenDate=" + screenDate
			+ "]";
}
}
