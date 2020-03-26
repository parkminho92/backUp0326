package com.kh.still_image.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

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
	
	
	
	
}
