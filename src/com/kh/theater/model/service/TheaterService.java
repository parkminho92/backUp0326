package com.kh.theater.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.room.model.vo.RoomCBS;
import com.kh.theater.model.dao.TheaterDao;
import com.kh.theater.model.vo.PageInfo;
import com.kh.theater.model.vo.Theater;
import com.kh.theater.model.vo.TheaterCBS;

public class TheaterService {

	/** 01. 紐⑤뱺 �쁺�솕愿� �젙蹂� -> list
	 * @return		紐⑤뱺 �쁺�솕愿� �젙蹂닿� �떞湲� 媛앹껜 -> list�뿉 �떞�븘�꽌
	 */
	public List<Theater> selectAll() {
		Connection conn = getConnection();
		
		List<Theater> list = new TheaterDao().selectAll(conn);
		
		close(conn);
		return list;
	}

	/** 02. 吏��뿭�궡�쓽 �쁺�솕愿� �젙蹂� -> list
	 * @param sectionNo	吏��뿭踰덊샇
	 * @return	吏��뿭 �궡�쓽 �쁺�솕愿� �젙蹂닿컼泥� -> list�뿉
	 */
	public List<Theater> selectAllBySection(String sectionNo) {
		Connection conn = getConnection();
		
		List<Theater> list = new TheaterDao().selectAllBySection(conn, sectionNo);
		
		close(conn);
		
		return list;
	}

	/** 03. �븳 �쁺�솕愿� �젙蹂� -> 媛앹껜
	 * @param theaterNo	�븘�슂�븳 �쁺�솕愿� 踰덊샇
	 * @return			�쁺�솕愿� 媛앹껜
	 */
	public Theater selectTheater(String theaterNo) {
		Connection conn = getConnection();
		
		Theater t = new TheaterDao().selectTheater(conn, theaterNo);
		
		close(conn);
		
		return t;
	}
	
	public int getTheaterListCount() {
		
		Connection conn = getConnection();

		int listCount = new TheaterDao().getOnListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<TheaterCBS> selectTheaterList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<TheaterCBS> list = new TheaterDao().selectTheaterList(conn,pi);
		
		close(conn);
		return list;
	}
	
	public int insertTheater(TheaterCBS t) {
		
		Connection conn = getConnection();
		
		int result = new TheaterDao().insertTheater(conn,t);
		
		if(result>0) {
			
			commit(conn);
		}else{
			
			rollback(conn);
		}
		close(conn);
		
		
		return result;
	}
	
	public TheaterCBS selectTheater(int theaterNo) {
		
		Connection conn = getConnection();
		
		TheaterCBS t = new TheaterDao().selectTheater(conn, theaterNo);
		
		close(conn);
		
		return t;
	}
	
	public ArrayList<RoomCBS> getRoomInfo(int TheaterNo) {
		
		Connection conn = getConnection();
		
		
		ArrayList<RoomCBS> list = new TheaterDao().getRoomInfo(conn,TheaterNo);
		
		close(conn);
		return list;
	}
	
	
	
}
