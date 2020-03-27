package com.kh.payment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;
import com.kh.payment.model.vo.Payment;

public class PaymentDao {

	Properties prop = new Properties();
	public PaymentDao(){ //기본생성자
		String fileName = PaymentDao.class.getResource("/sql/payment/payment-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 1. 예매번호로 결제번호 조회하기
	 * @param conn
	 * @param paymentNo
	 * @return
	 */
	public Payment paymentInfo(Connection conn, int paymentNo) {
		Payment paymentInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paymentNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				paymentInfo = new Payment(rset.getInt("PAYMENT_NO"), rset.getDate("DATE"),
						rset.getString("TYPE"), rset.getInt("AMOUNT"), rset.getString("REFUND_STATUS"),
						rset.getDate("REFUND_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return paymentInfo;
	}

	/** 2. 예매번호로 결제취소하기
	 * @param conn
	 * @param reservedNo
	 * @return
	 */
	public int cancelPayment(Connection conn, String reservedNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("cancelPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservedNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
