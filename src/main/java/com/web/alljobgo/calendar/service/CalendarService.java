package com.web.alljobgo.calendar.service;

import java.util.List;
import java.util.Map;

import org.w3c.dom.NodeList;

import com.web.alljobgo.calendar.domain.FavoriteVO;
import com.web.alljobgo.calendar.domain.HrdSearchVO;
import com.web.alljobgo.calendar.domain.ResponseVO;

public interface CalendarService {
	
	
	public List<FavoriteVO> getfavclass() throws Exception;
	
	public List getapi(String id) throws Exception;

}
