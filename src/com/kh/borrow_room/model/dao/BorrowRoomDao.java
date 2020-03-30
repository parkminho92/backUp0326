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

import com.kh.borrow_room.model.vo.BorrowRoom;
import com.kh.borrow_room.model.vo.PageInfo;

public class BorrowRoomDao {
	
	private Properties prop = new Properties();
	
	public BorrowRoomDao() {
		String fileName = BorrowRoomDao.class.getResource("/sql/borrow_room/borrow_room-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getListCount(Connection conn) {
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	public ArrayList<BorrowRoom> selectList(Connection conn, PageInfo pi){
		ArrayList<BorrowRoom> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new BorrowRoom(rset.getInt("borrow_room_no"),
										rset.getString("title"),
										rset.getDate("regi_date"),
										rset.getString("reply_status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public BorrowRoom selectBorrowRoom(Connection conn, int borrowNo) {
		BorrowRoom b = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBorrow");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, borrowNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new BorrowRoom(rset.getInt("member_no"),
								   rset.getString("email"),
								   rset.getInt("adult_count"),
								   rset.getInt("youth_count"),
								   rset.getInt("senior_count"),
								   rset.getInt("disabled_count"),
								   rset.getDate("hope_date"),
								   rset.getString("title"),
								   rset.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
}




















