package com.kh.screen.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.screen.model.dao.ScreenDao;
import com.kh.screen.model.dao.ScreenFlatDto;
import com.kh.screen.model.dao.ScreenSelectDto;
import com.kh.screen.model.vo.Screen;

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
		
		return screenNo;
	}
	
	

}
