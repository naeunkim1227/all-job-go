package com.web.alljobgo.calendar.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="scn_list")
public class ListVO {

	private List<HrdSearchVO> items;
	
	public List<HrdSearchVO> getItems() {
		return items;
	}

	public void setItems(List<HrdSearchVO> items) {
		this.items = items;
	}
	
	
	
	
	
	
	
}
