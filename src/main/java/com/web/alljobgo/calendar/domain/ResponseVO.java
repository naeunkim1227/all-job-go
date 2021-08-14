package com.web.alljobgo.calendar.domain;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HRDNet")
public class ResponseVO {
	
	private Map<String, String> header;
	private HrdSearchVO scn_list;
	
	public Map<String, String> getHeader() {
		return header;
	}
	public void setHeader(Map<String, String> header) {
		this.header = header;
	}
	public HrdSearchVO getScn_list() {
		return scn_list;
	}
	public void setScn_list(HrdSearchVO scn_list) {
		this.scn_list = scn_list;
	}
	
}
