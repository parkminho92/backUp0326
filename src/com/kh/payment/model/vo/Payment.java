package com.kh.payment.model.vo;

import java.util.Date;

public class Payment {

   /* PAYMENT_NO */
   private int paymentNo;

   /* DATE */
   private Date date;

   /* TYPE */
   private String type;

   /* AMOUNT */
   private int amount;

   /* REFUND_STATUS */
   private String refundStatus;

   /* REFUND_DATE */
   private Date refundDate;

public int getPaymentNo() {
	return paymentNo;
}

public void setPaymentNo(int paymentNo) {
	this.paymentNo = paymentNo;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public String getRefundStatus() {
	return refundStatus;
}

public void setRefundStatus(String refundStatus) {
	this.refundStatus = refundStatus;
}

public Date getRefundDate() {
	return refundDate;
}

public void setRefundDate(Date refundDate) {
	this.refundDate = refundDate;
}

public Payment(int paymentNo, Date date, String type, int amount, String refundStatus, Date refundDate) {
	super();
	this.paymentNo = paymentNo;
	this.date = date;
	this.type = type;
	this.amount = amount;
	this.refundStatus = refundStatus;
	this.refundDate = refundDate;
}

}
