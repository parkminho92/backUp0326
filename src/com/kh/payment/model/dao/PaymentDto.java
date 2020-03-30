package com.kh.payment.model.dao;

import java.util.Date;

public class PaymentDto {
	
	private String title;
	private Integer ageLimit;
	private Date screenDate;
	private String modifyName;
	
	
	
	public PaymentDto(String title, Integer ageLimit, Date screenDate, String modifyName) {
		super();
		this.title = title;
		this.ageLimit = ageLimit;
		this.screenDate = screenDate;
		this.modifyName = modifyName;
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
	public Date getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(Date screenDate) {
		this.screenDate = screenDate;
	}
	public String getModifyName() {
		return modifyName;
	}
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	
	
}
