package com.web.alljobgo.calender.service;

import java.util.List;
import java.util.Map;

import org.w3c.dom.NodeList;

import com.web.alljobgo.calender.domain.HrdSearchVO;
import com.web.alljobgo.calender.domain.ResponseVO;
import com.web.alljobgo.calender.domain.FavoriteVO;

public interface CalenderService {
	
	
	public List<FavoriteVO> getfavclass() throws Exception;
	
	public ResponseVO getapi(String id) throws Exception;

}
