package com.kh.borrow_room.model.vo;

import java.sql.Date;


public class BorrowRoom {
   /* BORROW_ROOM_NO */
   private int borrowRoomNo;

   /* MEMBER_NO */
   private int memberNo;

   /* TITLE */
   private String title;

   /* SECRET_STATUS */
   private String secretStatus;

   /* SECRET_PWD */
   private String secretPwd;

   /* ADULT_COUNT */
   private int adultCount;

   /* YOUTH_COUNT */
   private int youthCount;

   /* SENIOR_COUNT */
   private int seniorCount;

   /* DISABLED_COUNT */
   private int disabledCount;

   /* HOPE_DATE */
   private Date hopeDate;

   /* CONTENT */
   private String content;

   /* REGI_DATE */
   private Date regiDate;

   /* EMAIL */
   private String email;

   /* REPLY_STATUS */
   private String replyStatus;
   
   private Integer theaterNo;
   
   public BorrowRoom() {
	   
   }

   public BorrowRoom(int borrowRoomNo, int memberNo, String title, String secretStatus, String secretPwd, int adultCount,
			int youthCount, int seniorCount, int disabledCount, Date hopeDate, String content, Date regiDate,
			String email, String replyStatus) {
	   super();
	   this.borrowRoomNo = borrowRoomNo;
	   this.memberNo = memberNo;
	   this.title = title;
	   this.secretStatus = secretStatus;
	   this.secretPwd = secretPwd;
	   this.adultCount = adultCount;
	   this.youthCount = youthCount;
	   this.seniorCount = seniorCount;
	   this.disabledCount = disabledCount;
	   this.hopeDate = hopeDate;
	   this.content = content;
	   this.regiDate = regiDate;
	   this.email = email;
	   this.replyStatus = replyStatus;
   }
   
   public BorrowRoom(int memberNo, String email, int adultCount,
			int youthCount, int seniorCount, int disabledCount, Date hopeDate, String title, String content) {
	   super();
	   this.memberNo = memberNo;
	   this.email = email;
	   this.adultCount = adultCount;
	   this.youthCount = youthCount;
	   this.seniorCount = seniorCount;
	   this.disabledCount = disabledCount;
	   this.hopeDate = hopeDate;
	   this.title = title;
	   this.content = content;
   }

public BorrowRoom(int borrowRoomNo, String title) {
	super();
	this.borrowRoomNo = borrowRoomNo;
	this.title = title;
}

public int getBorrowRoomNo() {
	return borrowRoomNo;
}

public void setBorrowRoomNo(int borrowRoomNo) {
	this.borrowRoomNo = borrowRoomNo;
}

public int getMemberNo() {
	return memberNo;
}

public void setMemberNo(int memberNo) {
	this.memberNo = memberNo;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getSecretStatus() {
	return secretStatus;
}

public void setSecretStatus(String secretStatus) {
	this.secretStatus = secretStatus;
}

public String getSecretPwd() {
	return secretPwd;
}

public void setSecretPwd(String secretPwd) {
	this.secretPwd = secretPwd;
}

public int getAdultCount() {
	return adultCount;
}

public void setAdultCount(int adultCount) {
	this.adultCount = adultCount;
}

public int getYouthCount() {
	return youthCount;
}

public void setYouthCount(int youthCount) {
	this.youthCount = youthCount;
}

public int getSeniorCount() {
	return seniorCount;
}

public void setSeniorCount(int seniorCount) {
	this.seniorCount = seniorCount;
}

public int getDisabledCount() {
	return disabledCount;
}

public void setDisabledCount(int disabledCount) {
	this.disabledCount = disabledCount;
}

public Object getHopeDate() {
	return hopeDate;
}

public void setHopeDate(Date hopeDate) {
	this.hopeDate = hopeDate;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}


public Date getRegiDate() {
	return regiDate;
}


public void setRegiDate(Date regiDate) {
	this.regiDate = regiDate;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getReplyStatus() {
	return replyStatus;
}


public void setReplyStatus(String replyStatus) {
	this.replyStatus = replyStatus;
}


@Override
public String toString() {
	return "BorrowRoom [borrowRoomNo=" + borrowRoomNo + ", memberNo=" + memberNo + ", title=" + title
			+ ", secretStatus=" + secretStatus + ", secretPwd=" + secretPwd + ", adultCount=" + adultCount
			+ ", youthCount=" + youthCount + ", seniorCount=" + seniorCount + ", disabledCount=" + disabledCount
			+ ", hopeDate=" + hopeDate + ", content=" + content + ", regiDate=" + regiDate + ", email=" + email
			+ ", replyStatus=" + replyStatus + "]";
}

public Integer getTheaterNo() {
	return theaterNo;
}

public void setTheaterNo(Integer theaterNo) {
	this.theaterNo = theaterNo;
}


   
}
