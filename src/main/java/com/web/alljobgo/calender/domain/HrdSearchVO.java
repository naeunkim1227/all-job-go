package com.web.alljobgo.calender.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="items")
public class HrdSearchVO {
	
	private String trprId;
	private String trprDegr;
	private String trEndDt;
	private String trStaDt;
	
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
	
}
