package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Member loginMember(Connection conn, String userId, String userPwd) {
		
		Member loginUser = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getInt("member_no"),
									   rset.getString("grade"),
									   rset.getString("id"),
									   rset.getString("pwd"),
									   rset.getString("name"),
									   rset.getDate("birth"),
									   rset.getString("email"),
									   rset.getString("phone"),
									   rset.getString("tel"),
									   rset.getString("gender"),
									   rset.getInt("ticket_count"),
									   rset.getDate("signup_date"),
									   rset.getString("status"),
									   rset.getString("black_status"),
									   rset.getString("black_cause"),
									   rset.getInt("black_count"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* JDBCTemplate. */close(rset);
			/* JDBCTemplate. */close(pstmt);
		}
		return loginUser;
	}
	
	
	public int insertMember(Connection conn, Member m, String birth) {
		
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("insertMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPwd());
		pstmt.setString(3, m.getName());
		pstmt.setString(4, birth);
		pstmt.setString(5, m.getEmail());
		pstmt.setString(6, m.getPhone());
		pstmt.setString(7, m.getTel());
		pstmt.setString(8, m.getGender());
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
	

	}

	
	public Member selectMember(Connection conn, String userId) {
	
	Member mem = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			mem = new Member(rset.getInt("member_no"),
						   rset.getString("grade"),
						   rset.getString("id"),
						   rset.getString("pwd"),
						   rset.getString("name"),
						   rset.getDate("birth"),
						   rset.getString("email"),
						   rset.getString("phone"),
						   rset.getString("tel"),
						   rset.getString("gender"),
						   rset.getInt("ticket_count"),
						   rset.getDate("signup_date"),
						   rset.getString("status"),
						   rset.getString("black_status"),
						   rset.getString("black_cause"),
						   rset.getInt("black_count"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return mem;
	
	}

	
	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember"); 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int updatePwdMember(Connection conn, String id, String userPwd, String newPwd) {
	
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("updatePwdMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newPwd);
		pstmt.setString(2, id);
		pstmt.setString(3, userPwd);
		
		result = pstmt.executeUpdate();		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
	
	}
	
	
	public int deleteMember(Connection conn, String userId, String userPwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public Member findId(Connection conn, String name, String email) {
		
		Member findIdMem = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("findId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
	
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Member m = new Member();
				m.setId(rset.getString("id"));
				findIdMem = m;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return findIdMem;
		
		
	}
	
	
	public Member findPwd(Connection conn, String pId, String pName, String pPhone) {
		
		Member findPwdMem = null;

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("findPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pId);
			pstmt.setString(2, pName);
			pstmt.setString(3, pPhone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Member m = new Member();
				m.setPwd(rset.getString("pwd"));
				findPwdMem = m;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return findPwdMem;
			
	}
	
	public int idCheck(Connection conn, String userId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	
}