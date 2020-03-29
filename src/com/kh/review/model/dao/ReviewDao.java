package com.kh.review.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.review.model.vo.*;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/review/review-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ReviewLHJ> selectReviewList(Connection conn, int movieNo, int loginUserNo){
		
		ArrayList<ReviewLHJ> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()){
				ReviewLHJ r = new ReviewLHJ();
				r.setReviewNo(rset.getInt("REVIEW_NO"));
				r.setMemberNo(rset.getInt("MEMBER_NO"));
				r.setMovieNo(rset.getInt("MOVIE_NO"));
				r.setReviewText(rset.getString("REVIEW_TEXT"));
				r.setReviewRating(rset.getInt("REVIEW_RATING"));
				r.setBlindStatus(rset.getString("BLIND_STATUS"));
				r.setId(rset.getString("ID"));
				
				list.add(r);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
public int insertReview(Connection conn, ReviewLHJ r, int loginUserNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginUserNo);
			pstmt.setInt(2, r.getMovieNo());
			pstmt.setString(3, r.getReviewText());
			pstmt.setInt(4, r.getReviewRating());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}



}
