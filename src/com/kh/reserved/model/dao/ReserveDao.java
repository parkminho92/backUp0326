package com.kh.reserved.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.kh.reserved.model.vo.Reserved;


public class ReserveDao {

	Properties prop = new Properties();
	public ReserveDao(){ //기본생성자
		String fileName = ReserveDao.class.getResource("/sql/reserved/reserved-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 1. 결제
	 * @param conn
	 * @param payMethod	결제방식
	 * @param totalCost	결제금액
	 * @return
	 */
	public Integer reservePayment(Connection conn, String payMethod, Integer totalCost) {
		Integer payment = 0;

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reservePayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payMethod);
			pstmt.setInt(2, totalCost);
			
			payment = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return payment;
	}

	/** 2. 예매
	 * @param conn
	 * @param userNo	예매자번호
	 * @param screenNo	예매영화번호
	 * @return
	 */
	public Integer reserveMovie(Connection conn, Integer userNo, String screenNo) {
		Integer reserve = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reserveMovie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, screenNo);
			
			reserve = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return reserve;
	}

	/** 3. 예매좌석
	 * @param conn
	 * @param seatNo	예매좌석
	 * @return
	 */
	public Integer reserveSeat(Connection conn, String[] seatNo) {
		Integer reserveSeat = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reserveSeat");
		
		try {
			pstmt = conn.prepareStatement(sql);

			for(int i=0; i<seatNo.length; i++) {
				pstmt.setString(1, seatNo[i]);
				reserveSeat += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return reserveSeat;
	}

	/** 4. 예매 멤버타입별 인원수
	 * @param conn
	 * @param count	멤버타입별 인원수
	 * @return
	 */
	public Integer reserveMem(Connection conn, Map<String, String> count) {
		Integer reserveMem = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reserveMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(String key : count.keySet()) {
				Integer keyValue = 0;
				switch(key) {
				case "adult" : keyValue = 1; break;
				case "youth" : keyValue = 2; break;
				case "senior" : keyValue = 3; break;
				case "disabled" : keyValue =4; break;
				}
				pstmt.setInt(1, keyValue);
				pstmt.setString(2, count.get(key));
				reserveMem += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return reserveMem;
	}

	public Reserved reserveInfo(Connection conn, Integer userNo) {
		Reserved reserveInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reserveInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reserveInfo = new Reserved(rset.getInt("RESERVED_NO"), rset.getInt("PAYMENT_NO"), rset.getInt("MEMBER_NO"), rset.getInt("SCREEN_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reserveInfo;
	}

	public List<Integer> reservedSeats(Connection conn, String screenNo) {
		List<Integer> seats = new ArrayList<>();
		Set<Integer> seat = new HashSet<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reservedSeats");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, screenNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				seat.add(rset.getInt("SEAT_NO"));
			}
			seats = new ArrayList<>(seat);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		return seats;
	}
}
