package com.web.alljobgo.train.domain;

public class SearchVO {
	private String authKey;
	private String returnType;
	private String outType;
	private String pageNum;
	private String pageSize;
	private String srchTraArea1;
	private String srchTraArea2;
	private String srchKeco1;
	private String srchKeco2;
	private String srchKeco3;
	private String crseTracseSe;
	private String srchTraGbn;
	private String srchTraType;
	private String srchTraStDt;
	private String srchTraEndDt;
	private String srchTraProcessNm;
	private String srchTraOrganNm;
	private String sortCol;
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
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
	public String getSrchTraArea1() {
		return srchTraArea1;
	}
	public void setSrchTraArea1(String srchTraArea1) {
		this.srchTraArea1 = srchTraArea1;
	}
	public String getSrchTraArea2() {
		return srchTraArea2;
	}
	public void setSrchTraArea2(String srchTraArea2) {
		this.srchTraArea2 = srchTraArea2;
	}
	public String getSrchKeco1() {
		return srchKeco1;
	}
	public void setSrchKeco1(String srchKeco1) {
		this.srchKeco1 = srchKeco1;
	}
	public String getSrchKeco2() {
		return srchKeco2;
	}
	public void setSrchKeco2(String srchKeco2) {
		this.srchKeco2 = srchKeco2;
	}
	public String getSrchKeco3() {
		return srchKeco3;
	}
	public void setSrchKeco3(String srchKeco3) {
		this.srchKeco3 = srchKeco3;
	}
	public String getCrseTracseSe() {
		return crseTracseSe;
	}
	public void setCrseTracseSe(String crseTracseSe) {
		this.crseTracseSe = crseTracseSe;
	}
	public String getSrchTraGbn() {
		return srchTraGbn;
	}
	public void setSrchTraGbn(String srchTraGbn) {
		this.srchTraGbn = srchTraGbn;
	}
	public String getSrchTraType() {
		return srchTraType;
	}
	public void setSrchTraType(String srchTraType) {
		this.srchTraType = srchTraType;
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
	public String getSrchTraOrganNm() {
		return srchTraOrganNm;
	}
	public void setSrchTraOrganNm(String srchTraOrganNm) {
		this.srchTraOrganNm = srchTraOrganNm;
	}
	public String getSortCol() {
		return sortCol;
	}
	public void setSortCol(String sortCol) {
		this.sortCol = sortCol;
	}
	@Override
	public String toString() {
		return "SearchVO [authKey=" + authKey + ", returnType=" + returnType + ", outType=" + outType + ", pageNum="
				+ pageNum + ", pageSize=" + pageSize + ", srchTraArea1=" + srchTraArea1 + ", srchTraArea2="
				+ srchTraArea2 + ", srchKeco1=" + srchKeco1 + ", srchKeco2=" + srchKeco2 + ", srchKeco3=" + srchKeco3
				+ ", crseTracseSe=" + crseTracseSe + ", srchTraGbn=" + srchTraGbn + ", srchTraType=" + srchTraType
				+ ", srchTraStDt=" + srchTraStDt + ", srchTraEndDt=" + srchTraEndDt + ", srchTraProcessNm="
				+ srchTraProcessNm + ", srchTraOrganNm=" + srchTraOrganNm + ", sortCol=" + sortCol + "]";
	}
}
