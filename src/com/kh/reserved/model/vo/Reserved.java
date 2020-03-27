package com.kh.reserved.model.vo;

public class Reserved {
	/* RESERVED_NO */
	private int reservedNo;

	/* PAYMENT_NO */
	private int paymentNo;

	/* MEMBER_NO */
	private int memberNo;

	/* SCREEN_NO */
	private int screenNo;


	public Reserved() {

	}

	public Reserved(int reservedNo, int paymentNo, int memberNo, int screenNo) {
		super();
		this.reservedNo = reservedNo;
		this.paymentNo = paymentNo;
		this.memberNo = memberNo;
		this.screenNo = screenNo;
	}

	public int getReservedNo() {
		return reservedNo;
	}

	public void setReservedNo(int reservedNo) {
		this.reservedNo = reservedNo;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	
	@Override
	public String toString() {
		return "Reserved [reservedNo=" + reservedNo + ", paymentNo=" + paymentNo + ", memberNo=" + memberNo
				+ ", screenNo=" + screenNo + "]";
	}

	
	
}
