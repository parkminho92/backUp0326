package com.kh.theater.model.dao;

import java.util.ArrayList;
import java.util.List;

public class MovieDto {

	private Integer movieNo;
	private String title;
	private Integer ageLimit;
	
	private List<RoomDto> rooms;
	
	public MovieDto(Integer movieNo, String title, Integer ageLimit) {
		this(movieNo, title, ageLimit, new ArrayList<>());
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

	public List<RoomDto> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDto> rooms) {
		this.rooms = rooms;
	}

	public MovieDto(Integer movieNo, String title, Integer ageLimit, List<RoomDto> rooms) {
		this.movieNo = movieNo;
		this.title = title;
		this.ageLimit = ageLimit;
		this.rooms = rooms;
	}
	
	public void addRoomDto(RoomDto roomDto) {
		this.rooms.add(roomDto);
	}	

}
