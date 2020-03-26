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
	public ArrayList<Qna> selectList(Connection conn){
		
		ArrayList<Qna> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("selectList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				
				list.add(new Qna(rset.getInt("qna_No"),
								 rset.getInt("member_No"),
								 rset.getString("title"),
								 rset.getString("type"),
								 rset.getString("kind"),
								 rset.getDate("reg_Date"),
								 rset.getDate("reply_Date"),
								 rset.getString("secret_Status"),
								 rset.getString("secret_Pwd"),
								 rset.getString("content"),
								 rset.getString("reply_Content"),
								 rset.getString("reply_Status")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
		
	}
	
	public int insertQna(Connection conn, Qna q, int loginUserNo) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, loginUserNo);
			pstmt.setString(2, q.getTitle());
			pstmt.setString(3, q.getType());
			pstmt.setString(4,q.getKind());
			
			pstmt.setString(5, q.getSecretPwd());
			pstmt.setString(6, q.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
	
	return result;
	
	}
	
	
	public Qna selectQna(Connection conn, int qna_No) {
		
		Qna q = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qna_No);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna(rset.getInt("qna_No"),
						 rset.getInt("member_No"),
						 rset.getString("title"),
						 rset.getString("type"),
						 rset.getString("kind"),
						 rset.getDate("reg_Date"),
						 rset.getDate("reply_Date"),
						 rset.getString("secret_Status"),
						 rset.getString("secret_Pwd"),
						 rset.getString("content"),
						 rset.getString("reply_Content"),
						 rset.getString("reply_Status"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return q;
		
		
		
	}
	
	
	
}
