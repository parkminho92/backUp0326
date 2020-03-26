package com.kh.borrow_room.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.borrow_room.model.dao.BroomDao;
import com.kh.borrow_room.model.vo.BorrowRoom;

public class BroomService {

	public ArrayList<BorrowRoom> selectList(){
		
		Connection conn = getConnection();
		ArrayList<BorrowRoom> list = new BroomDao().selectList(conn);
		
		close(conn);
		return list;
		
	}
	
	public int insertBroom(BorrowRoom b, int loginUserNo, String bdate) {
		
		Connection conn = getConnection();
		int result = new BroomDao().insertBroom(conn, b, loginUserNo, bdate);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public BorrowRoom selectBroomDetail(int borrow_Room_No) {
		
		Connection conn = getConnection();
		BorrowRoom b = new BroomDao().selectBroomDetail(conn, borrow_Room_No);
		
		close(conn);
		
		return b;
	}
}
