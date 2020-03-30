package com.kh.screen.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.MovieCBS;
import com.kh.screen.model.dao.ScreenDao;
import com.kh.screen.model.dao.ScreenFlatDto;
import com.kh.screen.model.dao.ScreenSelectDto;
import com.kh.screen.model.vo.Screen;
import com.kh.screen.model.vo.ScreenCBS;

public class ScreenService {

	/** 1. 사용자가 제공한 정보를 통해 Screen 정보를 객체-->list에 담아옴
	 * @param theaterNo		극장번호
	 * @param movieNo		영화번호
	 * @param screenDate	상영날짜/시간
	 * @return				객체--> List에 담아서
	 */
	public List<Screen> selectScreen(String theaterNo, String movieNo, String screenDate) {
		Connection conn = getConnection();
		
		List<Screen> list = new ScreenDao().selectScreen(conn, theaterNo, movieNo, screenDate);
		
		close(conn);
		return list;
	}

	/** 2. 사용자가 제공한 정보를 통해 Screen 정보를 객체-->List에 담아옴
	 * @param theaterNo		극장번호
	 * @param screenDate	상영날짜/시간
	 * @return				스크린 객체-->List에 담아서
	 */
	public List<ScreenFlatDto> selectScreen(String theaterNo, String screenDate) {
		Connection conn = getConnection();
		
		List<ScreenFlatDto> list = new ScreenDao().selectScreen(conn, theaterNo, screenDate);
		
		close(conn);
		return list;
	}

	/** 3. ScreenNo를 통해 사용자에게 제공할 Screen 1개의 정보를 가져옴
	 * @param screenNo
	 * @return
	 */
	public ScreenSelectDto reservedScreen(String screenNo) {
		Connection conn = getConnection();
		ScreenSelectDto s = new ScreenDao().reservedScreen(conn, screenNo);
		
		close(conn);
		return s;
	}

	/** 4. 영화, 상영관, 상영시간을 통해 예약을 위한 Screen_no를 넘김
	 * @param movieNo
	 * @param roomNo
	 * @param screenTime
	 * @return
	 */
	public String screenTheater(String movieNo, String roomNo, String screenTime) {
		Connection conn = getConnection();
		
		String screenNo = new ScreenDao().screenTheater(conn, movieNo, roomNo, screenTime);	
		
		close(conn);
		
		return screenNo;
	}

	public int insertScreenInfo(int roomNo, int movieNo, String[] sDate) {
	
		Connection conn = getConnection();
		
		int result = new ScreenDao().insertScreenInfo(conn, roomNo, movieNo, sDate);
		
		if(result>0) {
			
			commit(conn);
		}else {
			
			rollback(conn);
		}
		close(conn);
			
		
		return result;
	}

	public ArrayList<ScreenCBS> selectWholeScreenInfo(int movieNo, int theaterNo) {
		
		Connection conn = getConnection();
		
		ArrayList<ScreenCBS> list = new ScreenDao().selectWholeMovie(conn,movieNo, theaterNo);
		
		close(conn);
		return list;
	}

	public ArrayList<ScreenCBS> updateScreenForm(int theaterNo) {
		
		Connection conn = getConnection();
		
		ArrayList<ScreenCBS> list = new ScreenDao().updateScreenForm(conn, theaterNo);
		
		close(conn);
		
		
		return list;
	}

	public int updateScreenInfo(int theaterNo, int movieNo, int screenNo, String screenDate) {
		
		Connection conn = getConnection();
		
		int result = new ScreenDao().updateScreenInfo(conn, theaterNo, movieNo, screenNo, screenDate);
		
		if(result>0) {
			commit(conn);
		}
			rollback(conn);
			close(conn);
			return result;
	}




}
