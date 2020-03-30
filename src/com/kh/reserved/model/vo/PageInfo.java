package com.kh.reserved.model.vo;

public class PageInfo { // 페이지 바의 관련 이야기
	private int totalCount;		//총게시글
	private int currentPage; 	//현재페이지(요청페이지)
	private int startPage;		//현재 페이지 하단에 보여지는 페이징 바의 시작번호
	private int endPage;		// " 끝번호
	private int maxPage;		//전체 페이지의 가장 마지막 페이지
	private int pageLimit;		//한 페이지에 보여질 페이지번호 최대 갯수
	private int countPerPage;		//한 페이지에 보여질 게시글 최대 갯수
	
	public PageInfo(int totalCount, PageRequest pageRequest) {
		// 변수초기화
		this.totalCount = totalCount;
		this.currentPage = pageRequest.getCurrentPage();
		this.pageLimit = 5;
		this.countPerPage = pageRequest.getCountPerPage();
		
		// 계산
		this.maxPage = (int)Math.ceil((this.totalCount / (this.countPerPage * 1.0)));
		this.startPage = (int)Math.floor((this.currentPage / this.pageLimit * 1.0)) + 1;
		
		this.endPage = this.startPage + this.pageLimit - 1;
		if(this.maxPage < this.endPage) {
			this.endPage = this.maxPage;
		}
	}

	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	
	
}
