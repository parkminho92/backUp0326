package com.kh.movie.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

	public class MovieCBS {
	
	  private int movieNo;

	   /* TITLE */
	   private String title;

	   /* RUNTIME */
	   private int runtime;

	   /* DIRECTOR */
	   private String director;

	   /* ACTOR */
	   private String actor;

	   /* AGE_LIMIT */
	   private int ageLimit;

	   /* SYNOPSIS */
	   private String synopsis;

	   /* ON_DATE */
	   private Date onDate;
	   
	   private String modifyName;

	   /* STATUS */
	   private String status;
	   
	   private String roomName;
	   
	   private Timestamp screenDate;

	 public MovieCBS() {
		super();
		
	}
	 
	 
	public MovieCBS(String title, String roomName, Timestamp screenDate) {
		super();
		this.title = title;
		this.roomName = roomName;
		this.screenDate = screenDate;
	}


	public MovieCBS(String title) {
		super();
		this.title = title;
	}
	
	

	

	public MovieCBS(int movieNo, String title) {
		super();
		this.movieNo = movieNo;
		this.title = title;
	}



	public MovieCBS(int movieNo, String title, int runtime, int ageLimit, Date onDate) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.runtime = runtime;
		this.ageLimit = ageLimit;
		this.onDate = onDate;
	}



	public MovieCBS(int movieNo, String title, int runtime, String director, String actor, int ageLimit,
			String synopsis, Date onDate) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.runtime = runtime;
		this.director = director;
		this.actor = actor;
		this.ageLimit = ageLimit;
		this.synopsis = synopsis;
		this.onDate = onDate;
	}



	public MovieCBS(String title, String director, String actor, Date onDate, int runtime,   int ageLimit, String synopsis
			) {
		super();
		this.title = title;
		this.runtime = runtime;
		this.director = director;
		this.actor = actor;
		this.ageLimit = ageLimit;
		this.synopsis = synopsis;
		this.onDate = onDate;
	}



	public MovieCBS(int movieNo, String title, int runtime, String director, String actor, int ageLimit,
			String synopsis, Date onDate, String modifyName) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.runtime = runtime;
		this.director = director;
		this.actor = actor;
		this.ageLimit = ageLimit;
		this.synopsis = synopsis;
		this.onDate = onDate;
		this.modifyName = modifyName;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

	public String getModifyName() {
		return modifyName;
	}

	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getRoomName() {
		return roomName;
	}





	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}







	public Timestamp getScreenDate() {
		return screenDate;
	}








	public void setScreenDate(Timestamp screenDate) {
		this.screenDate = screenDate;
	}








	@Override
	public String toString() {
		return "MovieCBS [movieNo=" + movieNo + ", title=" + title + ", runtime=" + runtime + ", director=" + director
				+ ", actor=" + actor + ", ageLimit=" + ageLimit + ", synopsis=" + synopsis + ", onDate=" + onDate
				+ ", modifyName=" + modifyName + ", status=" + status + "]";
	}
	 
	
	   
	   
}
