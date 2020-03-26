package com.kh.lostarticle.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.lostarticle.model.dao.LostDao;
import com.kh.lostarticle.model.vo.Lostarticle;

public class LostService {
	
	public ArrayList<Lostarticle> selectList(){
		
		Connection conn = getConnection();
		ArrayList<Lostarticle> list = new LostDao().selectList(conn);
		
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
