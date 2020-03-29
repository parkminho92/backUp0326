package com.kh.member_grade.model.service;

import java.sql.Connection;

import com.kh.member_grade.model.dao.MemberGradeDao;
import com.kh.member_grade.model.vo.MemberGrade;

import static com.kh.common.JDBCTemplate.*;

public class MemberGradeService {

	public MemberGrade selectGradeDiscount(Integer userNo) {
		Connection conn = getConnection();
		MemberGrade loginMg = new MemberGradeDao().selectGradeDiscount(conn, userNo);
		
		close(conn);
		return loginMg;
	}

}
