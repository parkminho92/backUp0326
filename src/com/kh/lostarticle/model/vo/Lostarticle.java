package com.kh.lostarticle.model.vo;

import java.sql.Date;

public class Lostarticle {
   /* LOST_NO */
   private int lostNo;

   /* MEMBER_NO */
   private int memberNo;

   /* TITLE */
   private String title;

   /* SECRET_STATUS */
   private String secretStatus;

   /* SECRET_PWD */
   private String secretPwd;

   /* NAME */
   private String name;

   /* PHONE */
   private String phone;

   /* EMAIL */
   private String email;

   /* PLACE */
   private String place;

   /* CONTENT */
   private String content;

   /* LOST_DATE */
   private Date lostDate;

   /* REPLY_CONTENT */
   private String replyContent;

   /* REPLY_STATUS */
   private String replyStatus;

   /* REPLY_DATE */
   private Date replyDate;

   public Lostarticle() {
	   
   }

public Lostarticle(int lostNo, int memberNo, String title, String secretStatus, String secretPwd, String name,
		String phone, String email, String place, String content, Date lostDate, String replyContent,
		String replyStatus, Date replyDate) {
	super();
	this.lostNo = lostNo;
	this.memberNo = memberNo;
	this.title = title;
	this.secretStatus = secretStatus;
	this.secretPwd = secretPwd;
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.place = place;
	this.content = content;
	this.lostDate = lostDate;
	this.replyContent = replyContent;
	this.replyStatus = replyStatus;
	this.replyDate = replyDate;
}

public Lostarticle(int lostNo, String title, String place, String replyStatus, Date lostDate) {
	super();
	this.lostNo = lostNo;
	this.title = title;
	this.place = place;
	this.replyStatus = replyStatus;
	this.lostDate = lostDate;
}

public Lostarticle(int lostNo, String place, Date lostDate, String name, String phone, String email, String title,  String content, String replyContent, String replyStatus) {
	super();
	this.lostNo = lostNo;
	this.place = place;
	this.lostDate = lostDate;
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.title = title;
	this.content = content;
	this.replyContent = replyContent;
	this.replyStatus = replyStatus;
}

public int getLostNo() {
	return lostNo;
}

public void setLostNo(int lostNo) {
	this.lostNo = lostNo;
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPlace() {
	return place;
}

public void setPlace(String place) {
	this.place = place;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public Date getLostDate() {
	return lostDate;
}

public void setLostDate(Date lostDate) {
	this.lostDate = lostDate;
}

public String getReplyContent() {
	return replyContent;
}

public void setReplyContent(String replyContent) {
	this.replyContent = replyContent;
}

public String getReplyStatus() {
	return replyStatus;
}

public void setReplyStatus(String replyStatus) {
	this.replyStatus = replyStatus;
}

public Date getReplyDate() {
	return replyDate;
}

public void setReplyDate(Date replyDate) {
	this.replyDate = replyDate;
}

@Override
public String toString() {
	return "Lostarticle [lostNo=" + lostNo + ", memberNo=" + memberNo + ", title=" + title + ", secretStatus="
			+ secretStatus + ", secretPwd=" + secretPwd + ", name=" + name + ", phone=" + phone + ", email=" + email
			+ ", place=" + place + ", content=" + content + ", lostDate=" + lostDate + ", replyContent=" + replyContent
			+ ", replyStatus=" + replyStatus + ", replyDate=" + replyDate + "]";
}
   
   
}
