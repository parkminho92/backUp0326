package com.kh.member_grade.model.service;

import java.sql.Connection;

import com.kh.member_grade.model.dao.MemberGradeDao;
import static com.kh.common.JDBCTemplate.*;

public class MemberGradeService {

	public Integer selectGradeDiscount(Integer userNo) {
		Connection conn = getConnection();
		int gradeDiscount = new MemberGradeDao().selectGradeDiscount(conn, userNo);
		
		close(conn);
		return gradeDiscount;
	}

}
