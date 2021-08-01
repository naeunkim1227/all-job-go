package com.web.alljobgo.train.domain;

public class SearchVO {
	private String returnType;
	private String outType;
	private String pageNum;
	private String pageSize;
	private String srchTraStDt;
	private String srchTraEndDt;
	private String srchTraProcessNm;
	private String sortCol;
	private String sort;
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getOutType() {
		return outType;
	}
	public void setOutType(String outType) {
		this.outType = outType;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getSrchTraStDt() {
		return srchTraStDt;
	}
	public void setSrchTraStDt(String srchTraStDt) {
		this.srchTraStDt = srchTraStDt;
	}
	public String getSrchTraEndDt() {
		return srchTraEndDt;
	}
	public void setSrchTraEndDt(String srchTraEndDt) {
		this.srchTraEndDt = srchTraEndDt;
	}
	public String getSrchTraProcessNm() {
		return srchTraProcessNm;
	}
	public void setSrchTraProcessNm(String srchTraProcessNm) {
		this.srchTraProcessNm = srchTraProcessNm;
	}
	public String getSortCol() {
		return sortCol;
	}
	public void setSortCol(String sortCol) {
		this.sortCol = sortCol;
	}
	@Override
	public String toString() {
		return "SearchVO [returnType=" + returnType + ", outType=" + outType + ", pageNum=" + pageNum + ", pageSize="
				+ pageSize + ", srchTraStDt=" + srchTraStDt + ", srchTraEndDt=" + srchTraEndDt + ", srchTraProcessNm="
				+ srchTraProcessNm + ", sortCol=" + sortCol + ", sort=" + sort + "]";
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public void insertByQuery(String query){
		System.out.println("쿼리 -> property");
	}
	public void insertByQuery(StringBuilder query){
		System.out.println("쿼리 -> property");
	}
}
