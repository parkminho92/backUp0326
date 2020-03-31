package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {

   /* NOTICE_NO */
   private int noticeNo;

   /* NOTICE_TYPE */
   private String noticeType;

   /* NOTICE_TITLE */
   private String noticeTitle;

   /* NOTICE_CONTENT */
   private String noticeContent;

   /* NOTICE_DATE */
   private Date noticeDate;

   /* REFERENCE */
   private int reference;
   
   /* STATUS */
   private String status;
   
   public Notice() {
	   
   }
   

	public Notice(int noticeNo, String noticeType, String noticeTitle, String noticeContent, Date noticeDate, int reference,
		String status) {
	super();
	this.noticeNo = noticeNo;
	this.noticeType = noticeType;
	this.noticeTitle = noticeTitle;
	this.noticeContent = noticeContent;
	this.noticeDate = noticeDate;
	this.reference = reference;
	this.status = status;
}


	public Notice(int noticeNo, String noticeType, String noticeTitle, String noticeContent, Date noticeDate,
			int reference) {
		super();
		this.noticeNo = noticeNo;
		this.noticeType = noticeType;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.reference = reference;
	}
	
	public Notice(int noticeNo, String noticeType, String noticeTitle, Date noticeDate, String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeType = noticeType;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.status = status;
	}
		


	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Object getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeType=" + noticeType + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", reference=" + reference
				+ ", status=" + status + "]";
	}
	
   
}
