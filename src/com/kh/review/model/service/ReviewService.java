package com.kh.review.model.service;

import static com.kh.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.review.model.dao.ReviewDao;
import com.kh.review.model.vo.*;


public class ReviewService {

	
	public ArrayList<ReviewLHJ> selectReviewList(int movieNo, int loginUserNo){
		
		Connection conn = getConnection();
		
		ArrayList<ReviewLHJ> list = new ReviewDao().selectReviewList(conn, movieNo, loginUserNo);
	
		close(conn);
		return list;
	}
	
	public int insertReview(ReviewLHJ r, int loginUserNo) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().insertReview(conn,r,loginUserNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
}
