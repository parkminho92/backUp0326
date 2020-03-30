package com.kh.lostarticle.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.lostarticle.model.dao.LostarticleDao;
import com.kh.lostarticle.model.vo.Lostarticle;
import com.kh.lostarticle.model.vo.PageInfo;

public class LostarticleService {

	/** 분실물 총 개수
	 * @return
	 */
	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new LostarticleDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/** 분실물 리스트
	 * @param pi
	 * @return
	 */
	public ArrayList<Lostarticle> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Lostarticle> list = new LostarticleDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/** 분실물 상세보기
	 * @param lostNo
	 * @return
	 */
	public Lostarticle selectAdminLost(int lostNo) {
		Connection conn = getConnection();
		
		Lostarticle l = null;
		
		l = new LostarticleDao().selectAdminLost(conn, lostNo);
		
		close(conn);
		
		return l;
	}
	
	public int replyLost(Lostarticle l) {
		Connection conn = getConnection();
		
		int result = new LostarticleDao().replyLost(conn, l);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
}
