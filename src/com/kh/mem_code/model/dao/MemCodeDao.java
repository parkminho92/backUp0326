package com.kh.mem_code.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.mem_code.model.vo.MemCode;

public class MemCodeDao {
	Properties prop = new Properties();
	public MemCodeDao(){ //기본생성자
		String fileName = MemCodeDao.class.getResource("/sql/mem_code/mem_code-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<MemCode> selectAll(Connection conn) {
		List<MemCode> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new MemCode(rset.getInt("MEM_CODE"), rset.getString("MEM_TYPE"), rset.getInt("MEM_PRICE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
