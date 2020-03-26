package com.kh.review.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.review.model.dao.ReviewDao;
import com.kh.review.model.vo.ReviewLHJ;

public class ReviewService {
	
	public ArrayList<ReviewLHJ> selectReviewList(int movieNo){
		
		Connection conn = getConnection();
		
		ArrayList<ReviewLHJ> list = new ReviewDao().selectReviewList(conn, movieNo);
	
		close(conn);
		return list;
	}
}
