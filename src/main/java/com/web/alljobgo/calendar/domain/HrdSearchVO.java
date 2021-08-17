package com.web.alljobgo.calendar.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="scn_list")
public class HrdSearchVO {
	
	private String trprId;
	private String trprDegr;
	private String trEndDt;
	private String trStaDt;
	private String trprNm;
	
	public String getTrprId() {
		return trprId;
	}
	public void setTrprId(String trprId) {
		this.trprId = trprId;
	}
	public String getTrprDegr() {
		return trprDegr;
	}
	public void setTrprDegr(String trprDegr) {
		this.trprDegr = trprDegr;
	}
	public String getTrEndDt() {
		return trEndDt;
	}
	public void setTrEndDt(String trEndDt) {
		this.trEndDt = trEndDt;
	}
	public String getTrStaDt() {
		return trStaDt;
	}
	public void setTrStaDt(String trStaDt) {
		this.trStaDt = trStaDt;
	}
	public String getTrprNm() {
		return trprNm;
	}
	public void setTrprNm(String trprNm) {
		this.trprNm = trprNm;
	}
	
	
	
}
