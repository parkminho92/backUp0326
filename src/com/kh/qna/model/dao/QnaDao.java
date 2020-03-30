package com.kh.qna.model.dao;

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

import com.kh.qna.model.vo.PageInfo;
import com.kh.qna.model.vo.Qna;


public class QnaDao {

	private Properties prop = new Properties();
	
	public QnaDao() {
		String fileName = QnaDao.class.getResource("/sql/qna/qna-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 1. Qna 전체 list 조회용 서비스
	 * @param conn
	 * @return
	 */
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
	

	public ArrayList<Qna> selectList(Connection conn, PageInfo pi) {
		ArrayList<Qna> list = new ArrayList<>();
		
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
				list.add(new Qna(rset.getInt("qna_no"),
								 rset.getString("type"),
								 rset.getString("kind"),
								 rset.getString("title"),
								 rset.getDate("reg_date"),
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
	
	public Qna selectAdminQna(Connection conn, int qnaNo) {
		Qna q = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdminQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna(rset.getInt("qna_no"),
							rset.getString("type"),
							rset.getString("kind"),
							rset.getInt("member_no"),
							rset.getDate("reg_date"),
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
		
		return q;
	}
	
	
	public int replyQna(Connection conn, Qna q) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("replyQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getReplyContent());
			pstmt.setInt(2, q.getQnaNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
