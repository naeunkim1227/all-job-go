package com.web.alljobgo.calendar.domain;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HRDNet")
public class HRDNetVO {
	
	private List<HrdSearchVO> scn_list;

	public List<HrdSearchVO> getScn_list() {
		return scn_list;
	}

	public void setScn_list(List<HrdSearchVO> scn_list) {
		this.scn_list = scn_list;
	}
	
	
}
