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

import com.kh.lostarticle.model.vo.Lostarticle;
import com.kh.lostarticle.model.vo.PageInfo;

public class LostarticleDao {

	private Properties prop = new Properties();
	
	public LostarticleDao() {
		String fileName = LostarticleDao.class.getResource("/sql/lostarticle/lostarticle-query.properties").getPath();
		
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
	
	public ArrayList<Lostarticle> selectList(Connection conn, PageInfo pi) {
		ArrayList<Lostarticle> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdminList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lostarticle(rset.getInt("lost_no"),
										 rset.getString("title"),
										 rset.getString("place"),
										 rset.getString("reply_status"),
										 rset.getDate("lost_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Lostarticle selectAdminLost(Connection conn, int lostNo) {
		Lostarticle l = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdminLost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lostNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				l = new Lostarticle(rset.getInt("lost_no"),
									rset.getString("place"),
									rset.getDate("lost_date"),
									rset.getString("name"),
									rset.getString("phone"),
									rset.getString("email"),
									rset.getString("title"),
									rset.getString("content"),
									rset.getString("reply_content"),
									rset.getString("reply_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return l;
	}
	
	public int replyLost(Connection conn, Lostarticle l) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("replyLost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getReplyContent());
			pstmt.setInt(2, l.getLostNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
