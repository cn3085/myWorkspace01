package org.spring.mvc.domain;

public class PageCriteria {
	private int Alldata;
	private int pageNow;
	private int perPageNum;
	private int pageStart;
	private int pageEnd;
	private int pageList;
	
	public int getAlldata() {
		return Alldata;
	}
	public void setAlldata(int alldata) {
		Alldata = alldata;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getPageList() {
		return pageList;
	}
	public void setPageList(int pageList) {
		this.pageList = pageList;
	}
	@Override
	public String toString() {
		return "PageCriteria [Alldata=" + Alldata + ", pageNow=" + pageNow + ", perPageNum=" + perPageNum
				+ ", pageStart=" + pageStart + ", pageEnd=" + pageEnd + ", pageList=" + pageList + "]";
	}
	
	
	
	

	
}
