package com.kh.still_image.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.still_image.model.vo.StillImage;

public class StillImageDao {

	Properties prop = new Properties();
	public StillImageDao(){ //기본생성자
		String fileName = StillImageDao.class.getResource("/sql/still_image/still_image-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String selectMain(Connection conn, String movieNo) {
		String mainPoster = "";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMain");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mainPoster = rset.getString("MODIFY_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mainPoster;
	}
	public ArrayList<StillImage> selectThList(Connection conn){
		
		ArrayList<StillImage> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				StillImage s = new StillImage();
				s.setAddfileNo(rset.getInt("ADDFILE_NO"));
				s.setOriginName(rset.getString("ORIGIN_NAME"));
				s.setModifyName(rset.getString("MODIFY_NAME"));
				s.setLevel(rset.getInt("LEVEL"));
				s.setMovieNo(rset.getInt("MOVIE_NO"));
				
				list.add(s);
				
				
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
