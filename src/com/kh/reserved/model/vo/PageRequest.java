package com.kh.reserved.model.vo;

import com.kh.common.StringUtils;

public class PageRequest { // 페이지에 따른 게시글 조회
	private static final int DEFAULT_COUNT_PER_PAGE = 10;	//페이지당 게시글 갯수(기본값)
	private int currentPage;	// 현재페이지
	private int offset;			// 시작값
	private int limit;			// 끝값
	private int countPerPage;	// 페이지당 게시글 갯수
	
	public PageRequest(String currentPage) {
		this(currentPage, String.valueOf(DEFAULT_COUNT_PER_PAGE));
	}		
	
	public PageRequest(String currentPage, String countPerPage) {
		this.currentPage = getCurrentPage(currentPage);
		this.countPerPage = getCountPerPage(countPerPage);
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
