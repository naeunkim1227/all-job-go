package com.web.alljobgo.calendar.service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.security.core.Authentication;
import org.w3c.dom.NodeList;

import com.web.alljobgo.calendar.domain.FavoriteVO;
import com.web.alljobgo.calendar.domain.HrdSearchVO;
import com.web.alljobgo.calendar.domain.HRDNetVO;

public interface CalendarService {
	
	
	public List<FavoriteVO> getfavclass() throws Exception;
	
	public Vector getapi(String id) throws Exception;

}
