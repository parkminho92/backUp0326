package com.kh.notice.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.model.vo.PageInfo;

public class NoticeService {

	/** 공지사항 총 개수
	 * @return
	 */
	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/** 공지사항 리스트 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Notice> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/** 공지사항 상세조회
	 * @param noticeNo
	 * @return
	 */
	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		
		Notice n = null;
		
		n = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		
		return n;
	}
	
	/** 공지사항 작성
	 * @param n
	 * @return
	 */
	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/** 공지사항 삭제
	 * @param noticeNo
	 * @return
	 */
	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
}
