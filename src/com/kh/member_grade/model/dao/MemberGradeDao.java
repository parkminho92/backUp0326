package com.kh.member_grade.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member_grade.model.vo.MemberGrade;

public class MemberGradeDao {
	Properties prop = new Properties();
	
	public MemberGradeDao() {
		String fileName = MemberGradeDao.class.getResource("/sql/member_grade/member_grade-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MemberGrade selectGradeDiscount(Connection conn, Integer userNo) {
		MemberGrade loginMg = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("gradeDiscount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				loginMg = new MemberGrade(rset.getString("GRADE_CONDITION"), rset.getString("GRADE_BENEFIT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return loginMg;
	}
	
}
