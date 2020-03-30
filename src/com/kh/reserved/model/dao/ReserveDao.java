package com.kh.reserved.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.kh.reserved.model.vo.PageRequest;
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
	
	/** 1_1. 결제 insert
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

	/** 1_2. 예매 insert
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

	/** 1_3. 예매좌석 insert
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

	/** 1_4. 예매 멤버타입별 인원수 insert
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

	/** 2. 사용자의 마지막 예약 정보 1개를 조회
	 * @param conn
	 * @param userNo
	 * @return
	 */
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

	/** 3. 상영관Screen별 예매된 좌석 정보 조회
	 * @param conn
	 * @param screenNo
	 * @return
	 */
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

	/** 4_1. 모든 예약 정보 (단, 현재 시간 까지) 
	 * @param conn
	 * @return
	 */
	public List<ListOfReserved> ListOfAllReserved(Connection conn, PageRequest pageRequest) {
		List<ListOfReserved> lor = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("listOfAllReserved");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,pageRequest.getOffset());
			pstmt.setInt(2,pageRequest.getLimit());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				lor.add(new ListOfReserved(rset.getInt("RESERVED_NO"), rset.getTimestamp("PAYMETN_DATE"),
						rset.getString("T_NAME"), rset.getString("R_NAME"), rset.getString("TITLE"), 
						rset.getInt("AGE_LIMIT"), rset.getTimestamp("SCREEN_DATE"), rset.getInt("PAYMENT_NO"),
						rset.getInt("AMOUNT"), rset.getString("TYPE"),
						rset.getInt("MEMBER_NO"), rset.getString("ID"), rset.getString("MODIFY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return lor;
	}

	
	/** 4_2. 예약번호 별 멤버(adult,...) 정보를 List으로 담기
	 * @param conn
	 * @param reservedNo
	 * @return
	 */
	public List<ListOfMemTypeDto> reservedMem(Connection conn, Integer reservedNo) {
		List<ListOfMemTypeDto> rsvMemType = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reservedMem");
	
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservedNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rsvMemType.add(new ListOfMemTypeDto(rset.getString("MEM_TYPE"), rset.getInt("RESERVED_COUNT")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rsvMemType;
	}

	/** 4_2. 예약번호 별 좌석번호 정보를 Integer[] 담기
	 * @param conn
	 * @param reservedNo
	 * @return
	 */
	public List<Integer> reservedSeats(Connection conn, Integer reservedNo) {
		List<Integer> seatNo = new ArrayList<Integer>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("seatByRsvNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservedNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				seatNo.add(rset.getInt("SEAT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return seatNo;
	}

	public ListOfReserved findReservedInfo(Connection conn, Integer reservedInfoId) {
		ListOfReserved reservedInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findReservedInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservedInfoId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reservedInfo = new ListOfReserved(rset.getInt("RESERVED_NO"), rset.getTimestamp("PAYMETN_DATE"),
						rset.getString("T_NAME"), rset.getString("R_NAME"), rset.getString("TITLE"), 
						rset.getInt("AGE_LIMIT"), rset.getTimestamp("SCREEN_DATE"), rset.getInt("PAYMENT_NO"),
						rset.getInt("AMOUNT"), rset.getString("TYPE"),
						rset.getInt("MEMBER_NO"), rset.getString("ID"), rset.getString("MODIFY_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reservedInfo;
	}

	public Integer reserveMemUpdate(Connection conn, Integer userNo) {
		Integer result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int countReserved(Connection conn) {
		int result = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countReserve");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		return result;
	}

	public List<ListOfReserved> findServedInfoByUserNo(Connection conn, Integer userNo) {
		List<ListOfReserved> lors = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findRSVInfoByUserNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				lors.add(new ListOfReserved(rset.getInt("RESERVED_NO"), rset.getTimestamp("PAYMETN_DATE"),
						rset.getString("T_NAME"), rset.getString("R_NAME"), rset.getString("TITLE"), 
						rset.getInt("AGE_LIMIT"), rset.getTimestamp("SCREEN_DATE"), rset.getInt("PAYMENT_NO"),
						rset.getInt("AMOUNT"), rset.getString("TYPE"),
						rset.getInt("MEMBER_NO"), rset.getString("ID"), rset.getString("MODIFY_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return lors;
	}

	public int countReserved(Connection conn, Integer userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countReserveOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public List<ListOfReserved> ListOfOneReserved(Connection conn, Integer userNo, PageRequest pageRequest) {
		List<ListOfReserved> lor = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("oneReserved");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, pageRequest.getOffset());
			pstmt.setInt(3, pageRequest.getLimit());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				lor.add(new ListOfReserved(rset.getInt("RESERVED_NO"), rset.getTimestamp("PAYMETN_DATE"),
						rset.getString("T_NAME"), rset.getString("R_NAME"), rset.getString("TITLE"), 
						rset.getInt("AGE_LIMIT"), rset.getTimestamp("SCREEN_DATE"), rset.getInt("PAYMENT_NO"),
						rset.getInt("AMOUNT"), rset.getString("TYPE"),
						rset.getInt("MEMBER_NO"), rset.getString("ID"), rset.getString("MODIFY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return lor;
	}
	
	
}
