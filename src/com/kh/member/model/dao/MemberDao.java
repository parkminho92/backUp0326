package com.kh.member.model.dao;

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

import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.PageInfo;

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
	
	public int findId(Connection conn, String id, String name, String email) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("findId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);

			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	/** 관리자 회원 리스트 총 개수
	 * @param conn
	 * @return
	 */
	public int adminListCount(Connection conn) {
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminListCount");
		
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
	
	/** 관리자 회원 리스트
	 * @param conn
	 * @param pi
	 * @return
	 */
	public ArrayList<Member> selectList(Connection conn, PageInfo pi) {
		ArrayList<Member> list = new ArrayList<>();
		
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
				list.add(new Member(rset.getInt("member_no"),
									rset.getString("id"),
									rset.getString("name"),
									rset.getString("grade"),
									rset.getString("gender"),
									rset.getDate("signup_date"),
									rset.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	/** 관리자 회원 상세보기
	 * @param conn
	 * @param memberNO
	 * @return
	 */
	public Member selectAdminMember(Connection conn, int memberNo) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdminMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getString("name"),
							   rset.getInt("member_no"),
							   rset.getString("id"),
							   rset.getDate("birth"),
							   rset.getString("gender"),
							   rset.getString("email"),
							   rset.getString("phone"),
							   rset.getString("tel"),
							   rset.getString("grade"),
							   rset.getDate("signup_date"),
							   rset.getString("status"),
							   rset.getString("black_status"),
							   rset.getString("black_cause"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
}