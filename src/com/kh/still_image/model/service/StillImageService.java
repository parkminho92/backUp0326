package com.kh.still_image.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.still_image.model.dao.StillImageDao;
import com.kh.still_image.model.vo.StillImage;

public class StillImageService {

	/** 1. 지정된 영화의 메인포스터의 수정이미지주소 가져오기
	 * @param movieNo 사용자가 지정한 영화번호
	 * @return			메인포스터의 수정이미지 주소
	 */
	public String selectMain(String movieNo) {
		Connection conn = getConnection();
		
		String mainPoster = new StillImageDao().selectMain(conn, movieNo);
		
		close(conn);
		return mainPoster;
	}
	
	public ArrayList<StillImage> selectThList(){
		
		Connection conn = getConnection();
		
		ArrayList<StillImage> list = new StillImageDao().selectThList(conn);
		
		close(conn);
		return list;
	
	}

	
}
