package com.kh.reserved.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.reserved.model.dao.ReserveDao;
import com.kh.reserved.model.vo.Reserved;

public class ReserveService {

	/** 1. 결제/예매/예매좌석/예매멤버타입 입력
	 * @param payMethod
	 * @param totalCost
	 * @param userNo
	 * @param screenNo
	 * @param seatNo
	 * @param count
	 * @return
	 */
	public Integer reserveMovie(String payMethod, Integer totalCost, Integer userNo, String screenNo, String[] seatNo,
			Map<String, String> count) {

		Connection conn = getConnection();
		Integer result = 0;
		
		//결제 : 결제번호, 결제날짜sysdate, 결제방식, 결제금액, 환불여부(n), 환불날짜
		//예매 : 예매번호, 결제번호, 결제자번호, screenNo
		//예매된좌석 : 예매번호, 좌석번호
		//예매인원 : 예매번호, 분류, 숫자
		
		Integer resultPayment = new ReserveDao().reservePayment(conn, payMethod, totalCost);
		Integer resultReserve = new ReserveDao().reserveMovie(conn, userNo, screenNo);
		Integer resultRsvSeat = new ReserveDao().reserveSeat(conn, seatNo);
		Integer resultRsvMem = new ReserveDao().reserveMem(conn, count);
		
		result = resultPayment*resultReserve*resultRsvSeat*resultRsvMem;
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	/** 2. 예약 정보 조회
	 * @param userNo 사용자
	 * @return
	 */
	public Reserved reserveInfo(Integer userNo) {
		Connection conn = getConnection();
		
		Reserved reserveInfo = new ReserveDao().reserveInfo(conn, userNo);
		
		close(conn);
		
		return reserveInfo;
	}

	/** 3. 스크린의 이미 예약된 좌석 정보 조회
	 * @param screenNo
	 * @return
	 */
	public List<Integer> reservedSeats(String screenNo) {
		Connection conn = getConnection();
		
		List<Integer> seats = new ReserveDao().reservedSeats(conn, screenNo);
		
		close(conn);
		
		return seats;
	}

}
