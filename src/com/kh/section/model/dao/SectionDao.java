package com.kh.section.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.section.model.vo.Section;

public class SectionDao {
	Properties prop = new Properties();
	public SectionDao(){ //기본생성자
		String fileName = SectionDao.class.getResource("/sql/section/section-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Section> selectAll(Connection conn) {
		List<Section> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Section(rset.getInt("SECTION_NO"),rset.getString("NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(stmt);
		}
		return list;
	}


	public List<SectionFlatDto> selectSectionDto(Connection conn) {
		List<SectionFlatDto> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectFlat");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new SectionFlatDto(rset.getInt("SECTION_NO"), rset.getString("SECTION_NAME"),
						rset.getInt("THEATER_NO"), rset.getString("THEATER_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}

}
