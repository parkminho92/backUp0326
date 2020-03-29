package com.kh.qna.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.qna.model.dao.QnaDao;
import com.kh.qna.model.vo.PageInfo;
import com.kh.qna.model.vo.Qna;

public class QnaService {

	/** Qna 총 개수
	 * @return
	 */
	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new QnaDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/** 1:1문의 리스트
	 * @param pi
	 * @return
	 */
	public ArrayList<Qna> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/** 1:1문의 상세조회
	 * @param qnaNo
	 * @return
	 */
	public Qna selectAdminQna(int qnaNo) {
		Connection conn = getConnection();
		
		Qna q = null;
		
		q = new QnaDao().selectAdminQna(conn, qnaNo);
		
		close(conn);
		
		return q;
	}
	
	/** 1:1문의 답변
	 * @param q
	 * @return
	 */
	public int replyQna(Qna q) {
		Connection conn = getConnection();
		
		int result = new QnaDao().replyQna(conn, q);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	

}
