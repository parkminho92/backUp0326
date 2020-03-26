package com.kh.borrow_room.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.borrow_room.model.dao.BorrowRoomDao;
import com.kh.borrow_room.model.vo.BorrowRoom;
import com.kh.borrow_room.model.vo.PageInfo;

public class BorrowRoomService {
	
	/** 대관문의 총개수
	 * @return
	 */
	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new BorrowRoomDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/** 대관문의 리스트 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<BorrowRoom> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<BorrowRoom> list = new BorrowRoomDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/** 대관문의 상세조회
	 * @param borrowNo
	 * @return
	 */
	public BorrowRoom selectBorrowRoom(int borrowNo) {
		Connection conn = getConnection();
		
		BorrowRoom b = null;
		
		b = new BorrowRoomDao().selectBorrowRoom(conn, borrowNo);
		
		close(conn);
		
		return b;
	}
}
