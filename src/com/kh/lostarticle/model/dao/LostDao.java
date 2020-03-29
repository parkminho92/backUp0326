package com.kh.lostarticle.model.dao;

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

import com.kh.lostarticle.model.vo.*;

public class LostDao {
	
	private Properties prop = new Properties();
	
	public LostDao() {
		String fileName = LostDao.class.getResource("/sql/lostarticle/lostarticle-query.properties").getPath();
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
	
	
	public ArrayList<Lostarticle> selectList(Connection conn, PageInfo pi){
			
			ArrayList<Lostarticle> list = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectList");
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
						
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Lostarticle(rset.getInt("LOST_NO"),
											 rset.getInt("MEMBER_NO"),
											 rset.getString("TITLE"),
											 rset.getString("SECRET_STATUS"),
											 rset.getString("SECRET_PWD"),
											 rset.getString("NAME"),
											 rset.getString("PHONE"),
											 rset.getString("EMAIL"),
											 rset.getString("PLACE"),
											 rset.getString("CONTENT"),
											 rset.getDate("LOST_DATE"),
											 rset.getString("REPLY_CONTENT"),
											 rset.getString("REPLY_STATUS"),
											 rset.getDate("REPLY_DATE")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
			
		}
	public Lostarticle selectLostDetail(Connection conn, int lost_No) {
		
		PreparedStatement pstmt = null;
		Lostarticle l = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lost_No);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				l = new Lostarticle(rset.getInt("lost_No"),
									rset.getInt("MEMBER_NO"),
									rset.getString("TITLE"),
									rset.getString("SECRET_STATUS"),
									rset.getString("SECRET_PWD"),
									rset.getString("NAME"),
									rset.getString("PHONE"),
									rset.getString("EMAIL"),
									rset.getString("PLACE"),
									rset.getString("CONTENT"),
									rset.getDate("LOST_DATE"),
									rset.getString("REPLY_CONTENT"),
									rset.getString("REPLY_STATUS"),
									rset.getDate("REPLY_DATE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return l;
		
	}
	
	public int insertLost(Connection conn, Lostarticle l, int loginUserNo, String Date) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertLost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginUserNo);
			pstmt.setString(2, l.getTitle());
			pstmt.setString(3, l.getSecretStatus());
			pstmt.setString(4, l.getSecretPwd());
			pstmt.setString(5, l.getName());
			pstmt.setString(6, l.getPhone());
			pstmt.setString(7, l.getEmail());
			pstmt.setString(8, l.getPlace());
			pstmt.setString(9, l.getContent());
			pstmt.setString(10, Date);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	

}
