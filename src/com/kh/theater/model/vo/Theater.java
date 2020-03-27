package com.kh.theater.model.vo;

public class Theater {
   /* THEATER_NO */
   private int theaterNo;

   /* NAME */
   private String name;

   /* ADDRESS */
   private String address;

   /* PHONE */
   private String phone;

/* ROOM_COUNT */
   private int roomCount;

   /* TRANSPORT */
   private String transport;

   /* PARKING */
   private String parking;

   /* LONGITUDE */
   private double longitude;

   /* LATITUDE */
   private double latitude;
   
   /* SECTION_NO */
   private int sectionNo;
   
   /* STATUS */
   private String status;
   
   
   public Theater() {
	   
   }
   
   public int getTheaterNo() {
	return theaterNo;
}
   
public Theater(int theaterNo, String name, String address, String phone, int roomCount, String transport,
		String parking, int longitude, int latitude, int sectionNo) {
	super();
	this.theaterNo = theaterNo;
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.roomCount = roomCount;
	this.transport = transport;
	this.parking = parking;
	this.longitude = longitude;
	this.latitude = latitude;
	this.sectionNo = sectionNo;
}

public void setTheaterNo(int theaterNo) {
	this.theaterNo = theaterNo;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public int getRoomCount() {
	return roomCount;
}


public void setRoomCount(int roomCount) {
	this.roomCount = roomCount;
}


public String getTransport() {
	return transport;
}


public void setTransport(String transport) {
	this.transport = transport;
}


public String getParking() {
	return parking;
}


public void setParking(String parking) {
	this.parking = parking;
}


public double getLongitude() {
	return longitude;
}


public void setLongitude(double longitude) {
	this.longitude = longitude;
}


public double getLatitude() {
	return latitude;
}


public void setLatitude(double latitude) {
	this.latitude = latitude;
}


public int getSectionNo() {
	return sectionNo;
}


public void setSectionNo(int sectionNo) {
	this.sectionNo = sectionNo;
}


public Theater(int theaterNo, String name, String address, String phone, int roomCount, String transport,
		   String parking, double longitude, double latitude, int sectionNo) {
	   this.theaterNo = theaterNo;
	   this.name = name;
	   this.address = address;
	   this.phone = phone;
	   this.roomCount = roomCount;
	   this.transport = transport;
	   this.parking = parking;
	   this.longitude = longitude;
	   this.latitude = latitude;
	   this.sectionNo = sectionNo;
   }

@Override
public String toString() {
	return "Theater [theaterNo=" + theaterNo + ", name=" + name + ", address=" + address + ", phone=" + phone
			+ ", roomCount=" + roomCount + ", transport=" + transport + ", parking=" + parking + ", longitude="
			+ longitude + ", latitude=" + latitude + ", sectionNo=" + sectionNo + "]";
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}



}
