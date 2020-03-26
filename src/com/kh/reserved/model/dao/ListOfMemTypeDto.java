package com.kh.reserved.model.dao;

public class ListOfMemTypeDto {
	private String memType;
	private int reservedCount;
	
	public String getMemType() {
		return memType;
	}
	public void setMemType(String memType) {
		this.memType = memType;
	}
	public int getReservedCount() {
		return reservedCount;
	}
	public void setReservedCount(int reservedCount) {
		this.reservedCount = reservedCount;
	}
	public ListOfMemTypeDto(String memType, int reservedCount) {
		this.memType = memType;
		this.reservedCount = reservedCount;
	}
}
