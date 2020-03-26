package com.kh.qna.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.qna.model.dao.QnaDao;
import com.kh.qna.model.vo.Qna;

public class QnaService {

	
	/** 1. Qna 전체 list 조회용 서비스
	 * @return
	 */
	public ArrayList<Qna> selectList(){
		
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectList(conn);
		
		close(conn);
		return list;
	}
	
	public int insertQna(Qna q, Integer loginUserNo) {
		Connection conn = getConnection();
		
		int result = new QnaDao().insertQna(conn, q, loginUserNo);
		
		if(result >0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
		
	}
	public Qna selectQna(int qna_No) {
		Connection conn = getConnection();
		
		Qna q = new QnaDao().selectQna(conn,qna_No);
		
		close(conn);
		return q;
	}
	

	
	
	
	
	
	
	
	
}
