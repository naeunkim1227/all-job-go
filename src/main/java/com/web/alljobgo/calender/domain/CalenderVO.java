package com.web.alljobgo.calender.domain;

public class CalenderVO {
	private String returntype;
	private String outType;
	private String srchTrprId;
	private String srchTrprDegr;
	private String srchTraStDt;
	private String srchTraEndDt;
	private String srchTraProcessNm;
	public String getReturntype() {
		return returntype;
	}
	public void setReturntype(String returntype) {
		this.returntype = returntype;
	}
	public String getOutType() {
		return outType;
	}
	public void setOutType(String outType) {
		this.outType = outType;
	}
	public String getSrchTrprId() {
		return srchTrprId;
	}
	public void setSrchTrprId(String srchTrprId) {
		this.srchTrprId = srchTrprId;
	}
	public String getSrchTrprDegr() {
		return srchTrprDegr;
	}
	public void setSrchTrprDegr(String srchTrprDegr) {
		this.srchTrprDegr = srchTrprDegr;
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
	@Override
	public String toString() {
		return "CalenderVO [returntype=" + returntype + ", outType=" + outType + ", srchTrprId=" + srchTrprId
				+ ", srchTrprDegr=" + srchTrprDegr + ", srchTraStDt=" + srchTraStDt + ", srchTraEndDt=" + srchTraEndDt
				+ ", srchTraProcessNm=" + srchTraProcessNm + "]";
	}

	
	
}
