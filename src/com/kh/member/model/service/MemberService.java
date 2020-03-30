package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.PageInfo;

public class MemberService {

	
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);

		close(conn);
	
		return loginUser;
	}
	
	
	public int insertMember(Member mem, String birth) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, mem, birth);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	
	
	}
	
	
	public Member selectMember(String userId) {
		Connection conn = getConnection();
		
		Member mem = new MemberDao().selectMember(conn, userId);
		
		close(conn);
		
		return mem;
	}

	
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getId());
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
		
	}
	

	public int updatePwdMember(String id, String userPwd, String newPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwdMember(conn, id, userPwd, newPwd);
		
		if(result > 0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	

	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public Member findId(String name, String email) {
		Connection conn = getConnection();
		
		Member findIdMem = new MemberDao().findId(conn, name, email);
		
		close(conn);
		
		return findIdMem;
		
		
		}
	/** 관리자 회원 리스트 총 개수
	 * @return
	 */
	public int adminListCount() {
		Connection conn = getConnection();
		
		int listCount = new MemberDao().adminListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/** 관리자 회원 리스트
	 * @param pi
	 * @return
	 */
	public ArrayList<Member> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/** 관리자 회원 상세보기
	 * @param memberNo
	 * @return
	 */
	public Member selectAdminMember(int memberNo) {
		Connection conn = getConnection();
		
		Member m = null;
		
		m = new MemberDao().selectAdminMember(conn, memberNo);
		
		close(conn);
		
		return m;
	}
	
	/** 관리자 회원 등급 바꾸기
	 * @param m
	 * @return
	 */
	public int adminGrade(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().adminGrade(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
}