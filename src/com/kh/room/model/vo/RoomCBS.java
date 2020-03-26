package com.kh.room.model.vo;

public class RoomCBS {
   /* ROOM_NO */
   private int roomNo;

   /* THEATER_NO */
   private int theaterNo;

   /* SEAT_COUNT */
   private int seatCount;

   /* NAME */
   private String name;

public RoomCBS() {
	super();
	// TODO Auto-generated constructor stub
}

public RoomCBS(int roomNo, int theaterNo, int seatCount, String name) {
	super();
	this.roomNo = roomNo;
	this.theaterNo = theaterNo;
	this.seatCount = seatCount;
	this.name = name;
}

public RoomCBS(int roomNo, int seatCount, String name) {
	super();
	this.roomNo = roomNo;
	this.seatCount = seatCount;
	this.name = name;
}

public int getRoomNo() {
	return roomNo;
}

public void setRoomNo(int roomNo) {
	this.roomNo = roomNo;
}

public int getTheaterNo() {
	return theaterNo;
}

public void setTheaterNo(int theaterNo) {
	this.theaterNo = theaterNo;
}

public int getSeatCount() {
	return seatCount;
}

public void setSeatCount(int seatCount) {
	this.seatCount = seatCount;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "Room [roomNo=" + roomNo + ", theaterNo=" + theaterNo + ", seatCount=" + seatCount + ", name=" + name + "]";
}




   
   
}
