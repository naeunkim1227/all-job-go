package com.web.alljobgo.calender.service;

import java.util.List;

import com.web.alljobgo.calender.domain.HrdSearchVO;
import com.web.alljobgo.calender.domain.FavoriteVO;

public interface CalenderService {
	
	public List<HrdSearchVO> listAll() throws Exception;
	
	public List<FavoriteVO> getfavclass() throws Exception;
	
	

}
