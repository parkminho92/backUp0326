package com.kh.member_grade.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

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

	public int selectGradeDiscount(Connection conn, Integer userNo) {
		int gradeDiscount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("gradeDiscount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				gradeDiscount = rset.getInt("GRADE_BENEFIT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return gradeDiscount;
	}
	
}
