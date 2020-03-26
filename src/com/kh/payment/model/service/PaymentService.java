package com.kh.payment.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.payment.model.dao.PaymentDao;
import com.kh.payment.model.vo.Payment;

public class PaymentService {

	/** 1. 예매번호로 결제번호 조회하기
	 * @param reservedNo 예매번호
	 * @return
	 */
	public Payment paymentInfo(int paymentNo) {
		Connection conn = getConnection();
		
		Payment paymentInfo = new PaymentDao().paymentInfo(conn, paymentNo);
		
		close(conn);
		return paymentInfo;
	}

}
