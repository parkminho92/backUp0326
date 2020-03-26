package com.kh.section.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.section.model.dao.SectionDao;
import com.kh.section.model.dao.SectionFlatDto;
import com.kh.section.model.vo.Section;

public class SectionService {

	public List<Section> selectAll() {
		Connection conn = getConnection();
		
		List<Section> list = new SectionDao().selectAll(conn);
		
		close(conn);
		
		return list;
	}

	public List<SectionFlatDto> selectSectionDto() {
		Connection conn = getConnection();
		
		List<SectionFlatDto> sectionFlat = new SectionDao().selectSectionDto(conn);
		
		close(conn);
		
		return sectionFlat;
	}

}
