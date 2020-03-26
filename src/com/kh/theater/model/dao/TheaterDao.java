package com.kh.theater.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.room.model.vo.RoomCBS;
import com.kh.theater.model.vo.PageInfo;
import com.kh.theater.model.vo.Theater;
import com.kh.theater.model.vo.TheaterCBS;

public class TheaterDao {
	Properties prop = new Properties();
	public TheaterDao(){ //湲곕낯�깮�꽦�옄
		String fileName = TheaterDao.class.getResource("/sql/theater/theater-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public List<Theater> selectAll(Connection conn) {
		List<Theater> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Theater(rset.getInt("THEATER_NO"), rset.getString("NAME"),
						rset.getString("ADDRESS"), rset.getString("PHONE"), rset.getInt("ROOM_COUNT"),
						rset.getString("TRANSPORT"), rset.getString("PARKING"), rset.getDouble("LONGITUDE"),
						rset.getDouble("LATITUDE"), rset.getInt("SECTION_NO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(stmt);
		}
		return list;
	}
	
	public List<Theater> selectAllBySection(Connection conn, String sectiontNo){
		List<Theater> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sectiontNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Theater(rset.getInt("THEATER_NO"), rset.getString("NAME"),
						rset.getString("ADDRESS"), rset.getString("PHONE"), rset.getInt("ROOM_COUNT"),
						rset.getString("TRANSPORT"), rset.getString("PARKING"), rset.getDouble("LONGITUDE"),
						rset.getDouble("LATITUDE"), rset.getInt("SECTION_NO")));
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Theater selectTheater(Connection conn, String theaterNo) {
		Theater t = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTheater");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theaterNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				t = new Theater(rset.getInt("THEATER_NO"), rset.getString("NAME"), rset.getString("ADDRESS"),
						rset.getString("PHONE"), rset.getInt("ROOM_COUNT"), rset.getString("TRANSPORT"),
						rset.getString("PARKING"), rset.getDouble("LONGITUDE"), rset.getDouble("LATITUDE"),
						rset.getInt("SECTION_NO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return t;
	}
	
	public int getOnListCount(Connection conn) {
		
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getTheaterCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	public ArrayList<TheaterCBS> selectTheaterList(Connection conn, PageInfo pi) {
		
		ArrayList<TheaterCBS> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTheaterList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new TheaterCBS(rset.getInt("theater_no"),
								   rset.getString("tname"),
								   rset.getInt("room_count"),
								   rset.getString("sname")));
								
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public int insertTheater(Connection conn, TheaterCBS t) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertTheater");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getAddress());
			pstmt.setString(3, t.getPhone());
			pstmt.setInt(4, t.getRoomCount());
			pstmt.setString(5, t.getTransport());
			pstmt.setString(6, t.getParking());
			pstmt.setDouble(7, t.getLongitude());
			pstmt.setDouble(8, t.getLatitude());
			pstmt.setInt(9,t.getSectionNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			close(pstmt);
		}
		
		return result;
	}
	
public TheaterCBS selectTheater(Connection conn, int theaterNo) {
		
		TheaterCBS t = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTheater1");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, theaterNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				t= new TheaterCBS(rset.getInt("theater_no"),
								rset.getString("name"),
								rset.getString("address"),
								rset.getString("phone"),
								rset.getInt("room_count"),
								rset.getString("transport"),
								rset.getString("parking"),
								rset.getDouble("longitude"),
								rset.getDouble("latitude"),
								rset.getInt("section_no"),
								rset.getString("section_name"));
					
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return t;
	}

	public ArrayList<RoomCBS> getRoomInfo(Connection conn, int theaterNo) {
	
	ArrayList<RoomCBS> list = new ArrayList<>();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectRoomInfo");
	
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, theaterNo);
		rset = pstmt.executeQuery();
		
		
		while(rset.next()) {
			list.add(new RoomCBS(rset.getInt("room_no"),
							  rset.getInt("seat_count"),
							  rset.getString("name")));
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
	}
			
			
	
	return list;
}
	

}
