package com.kh.mem_code.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.mem_code.model.dao.MemCodeDao;
import com.kh.mem_code.model.vo.MemCode;

public class MemCodeService {

	/** 1. 모든 멤버코드 List
	 * @return 모든 멤버코드 정보 담은 List
	 */
	public List<MemCode> selectAll() {
		Connection conn = getConnection();
		
		List<MemCode> list = new MemCodeDao().selectAll(conn);
	
		close(conn);
		
		return list;
	}

}
