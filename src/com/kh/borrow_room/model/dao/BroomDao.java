package com.kh.borrow_room.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Date;

import com.kh.borrow_room.model.vo.BorrowRoom;

public class BroomDao {
	
	private Properties prop = new Properties();
	
	public BroomDao() {
		String fileName = BroomDao.class.getResource("/sql/borrow_room/borrow_room-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 1. 대관문의 게시판 조회용 서비스
	 * @param conn
	 * @return
	 */
	public ArrayList<BorrowRoom> selectList(Connection conn){
		
		ArrayList<BorrowRoom> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBroom");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new BorrowRoom(rset.getInt("BORROW_ROOM_NO"),
										rset.getInt("MEMBER_NO"),
										rset.getString("TITLE"),
										rset.getString("SECRET_STATUS"),
										rset.getString("SECRET_PWD"),
										rset.getInt("ADULT_COUNT"),
										rset.getInt("YOUTH_COUNT"),
										rset.getInt("SENIOR_COUNT"),
										rset.getInt("DISABLED_COUNT"),
										rset.getDate("HOPE_DATE"),
										rset.getString("CONTENT"),
										rset.getDate("REGI_DATE"),
										rset.getString("EMAIL"),
										rset.getString("REPLY_STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
		
	}
	
public int insertBroom(Connection conn, BorrowRoom b, int loginUserNo, String bdate) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBroom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginUserNo);
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getSecretStatus());
			pstmt.setString(4, b.getSecretPwd());
			pstmt.setInt(5, b.getAdultCount());
			pstmt.setInt(6, b.getYouthCount());
			pstmt.setInt(7, b.getSeniorCount());
			pstmt.setInt(8,b.getDisabledCount());
			pstmt.setString(9, bdate);
			pstmt.setString(10, b.getContent());
			pstmt.setString(11, b.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public BorrowRoom selectBroomDetail(Connection conn, int borrow_Room_No) {
		
		PreparedStatement pstmt = null;
		BorrowRoom b = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, borrow_Room_No);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new BorrowRoom(rset.getInt("borrow_Room_No"),
								   rset.getInt("MEMBER_NO"),
								   rset.getString("TITLE"),
								   rset.getString("SECRET_STATUS"),
								   rset.getString("SECRET_PWD"),
								   rset.getInt("ADULT_COUNT"),
								   rset.getInt("YOUTH_COUNT"),
								   rset.getInt("SENIOR_COUNT"),
								   rset.getInt("DISABLED_COUNT"),
								   rset.getDate("HOPE_DATE"),
								   rset.getString("CONTENT"),
								   rset.getDate("REGI_DATE"),
								   rset.getString("EMAIL"),
								   rset.getString("REPLY_STATUS"));
		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
		
		
		
		
		
	}

}
