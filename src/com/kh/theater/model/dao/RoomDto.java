package com.kh.theater.model.dao;

import java.util.Date;

public class RoomDto {

	private Integer roomNo;
	private String roomName;
	private Date screenDate;
	
	public RoomDto(Integer roomNo, String roomName, Date screenDate) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.screenDate = screenDate;
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

	public Date getScreenDate() {
		return screenDate;
	}

	public void setScreenDate(Date screenDate) {
		this.screenDate = screenDate;
	}
	
}
