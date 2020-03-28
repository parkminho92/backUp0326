package com.kh.reserved.model.vo;

import com.kh.common.StringUtils;

public class PageRequest {
	private static final int DEFAULT_COUNT_PER_PAGE = 10;
	private int currentPage;
	private int offset;
	private int limit;
	private int countPerPage;
	
	public PageRequest(String currentPage) {
		this(currentPage, String.valueOf(DEFAULT_COUNT_PER_PAGE));
	}		
	
	public PageRequest(String currentPage, String countPerPage) {
		this.currentPage = getCurrentPage(currentPage);
		this.countPerPage = getCountPerPage(countPerPage);
		
		// 1 페이지고
		// 페이지당 10개씩
		// 2 // 11
		// offset (currentPage - 1) * limit + 1   
		// limit (currentPage * limit) 마지막 게시글의 로우수 
		
		this.offset = (this.currentPage - 1) * this.countPerPage + 1 ;
		this.limit = this.currentPage * this.countPerPage;
	}
	
	// == 헬퍼 메소드  == //
	
	private int getCurrentPage(String currentPage) {
		if (StringUtils.isEmpty(currentPage) || !StringUtils.isInteger(currentPage)) {
			return 1;
		} 
		return Integer.parseInt(currentPage);
	}
	
	private int getCountPerPage(String countPerPage) {
		if (StringUtils.isEmpty(countPerPage) || !StringUtils.isInteger(countPerPage)) {
			return DEFAULT_COUNT_PER_PAGE;
		}
		return  Integer.parseInt(countPerPage);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public int getCountPerPage() {
		return countPerPage;
	}
	
	
}
