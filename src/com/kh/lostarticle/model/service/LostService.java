package com.kh.lostarticle.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.lostarticle.model.dao.LostDao;
import com.kh.lostarticle.model.vo.*;

public class LostService {
	
	public int getListCount() {
			
			Connection conn = getConnection();
			
			int listCount = new LostDao().getListCount(conn);
			
			close(conn);
			return listCount;
			
		}
	
	public ArrayList<Lostarticle> selectList(PageInfo pi){
			
			Connection conn = getConnection();
			ArrayList<Lostarticle> list = new LostDao().selectList(conn,pi);
			
			close(conn);
			return list;
		}
	
	public Lostarticle selectLostDetail(int lost_No) {
		Connection conn = getConnection();
		Lostarticle l = new LostDao().selectLostDetail(conn,lost_No);
		
		close(conn);
		
		return l;
	}

	public int insertLost(Lostarticle l, int loginUserNo, String Date) {
		
		Connection conn = getConnection();
		int result = new LostDao().insertLost(conn,l, loginUserNo, Date);
	
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	
	}
}
