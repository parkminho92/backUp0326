package com.kh.screen.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.screen.model.vo.Screen;

public class ScreenDao {
	Properties prop = new Properties();
	public ScreenDao(){ //기본생성자
		String fileName = ScreenDao.class.getResource("/sql/screen/screen-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Screen> selectScreen(Connection conn, String theaterNo, String movieNo, String screenDate) {
		List<Screen> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSchedule");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, screenDate);
			pstmt.setString(2, movieNo);
			pstmt.setString(3, theaterNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Screen(rset.getInt("SCREEN_NO"), rset.getInt("ROOM_NO"),
						rset.getInt("MOVIE_NO"), rset.getTimestamp("SCREEN_DATE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public List<ScreenFlatDto> selectScreen(Connection conn, String theaterNo, String screenDate) {
		List<ScreenFlatDto> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectScreenDto");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, screenDate);
			pstmt.setString(2, theaterNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ScreenFlatDto(rset.getInt("THEATER_NO"), rset.getInt("ROOM_NO"), rset.getString("NAME"),
						rset.getInt("SCREEN_NO"), rset.getInt("MOVIE_NO"), rset.getString("TITLE"), 
						rset.getInt("AGE_LIMIT"), rset.getTimestamp("SCREEN_DATE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ScreenSelectDto reservedScreen(Connection conn, String screenNo) {
		ScreenSelectDto s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reservedScreen");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, screenNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				s = new ScreenSelectDto(
						rset.getInt("SCREEN_NO"), rset.getInt("THEATER_NO"), rset.getString("THEATER_NAME"),
						rset.getInt("ROOM_NO"), rset.getString("ROOM_NAME"), rset.getInt("MOVIE_NO"), rset.getString("TITLE"),
						rset.getInt("AGE_LIMIT"), rset.getTimestamp("SCREEN_DATE"), rset.getInt("MAINPOSTER"), rset.getString("MODIFY_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return s;
	}

	public String screenTheater(Connection conn, String movieNo, String roomNo, String screenTime) {
		String screenNo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("screenTh");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieNo);
			pstmt.setString(2, roomNo);
			pstmt.setString(3, screenTime);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				screenNo = rset.getString("SCREEN_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return screenNo;
	}
}
