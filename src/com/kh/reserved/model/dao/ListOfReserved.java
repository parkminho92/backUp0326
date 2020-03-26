package com.kh.reserved.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListOfReserved {
	private Integer reservedNo;		// 예매번호
	private Date paymentDate;		// 예매/결제일자
	private String theaterName;		// 극장명
	private String roomName;		// 상영관명
	private String title;			// 영화제목
	private Integer ageLimit;		// 영화나이제한
	private Date screenDate;		// 상영일자
	private Integer paymentNo;		// 결제번호
	private Integer amount;			// 결제액
	private String paymentType;		// 결제방법
	private Integer memberNo;		// 예매자번호
	private String memberId;		// 예매자아이디
	private String modifyName;		// 포스터수정명

	private List<ListOfMemTypeDto> rsvMemType = new ArrayList<>();		// 예매번호별 멤버 정보
	private List<Integer> seatNo = new ArrayList<>();					// 예매번호별 좌석 정보
	
	

	public ListOfReserved(Integer reservedNo, Date paymentDate, String theaterName, String roomName, String title,
			Integer ageLimit, Date screenDate, Integer paymentNo, Integer amount, String paymentType, Integer memberNo,
			String memberId, String modifyName) {
		this.reservedNo = reservedNo;
		this.paymentDate = paymentDate;
		this.theaterName = theaterName;
		this.roomName = roomName;
		this.title = title;
		this.ageLimit = ageLimit;
		this.screenDate = screenDate;
		this.paymentNo = paymentNo;
		this.amount = amount;
		this.paymentType = paymentType;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.modifyName = modifyName;
	}
	public List<ListOfMemTypeDto> getRsvMemType() {
		return rsvMemType;
	}
	public void setRsvMemType(List<ListOfMemTypeDto> rsvMemType) {
		this.rsvMemType = rsvMemType;
	}
	public List<Integer> getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(List<Integer> seatNo) {
		this.seatNo = seatNo;
	}
	public Integer getReservedNo() {
		return reservedNo;
	}
	public void setReservedNo(Integer reservedNo) {
		this.reservedNo = reservedNo;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
	public Integer getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(Integer paymentNo) {
		this.paymentNo = paymentNo;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getModifyName() {
		return modifyName;
	}
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}
	
	
	
}
