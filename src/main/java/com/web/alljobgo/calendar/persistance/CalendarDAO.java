package com.web.alljobgo.calendar.persistance;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;

import com.web.alljobgo.calendar.domain.FavoriteVO;
import com.web.alljobgo.calendar.domain.HrdSearchVO;

public interface CalendarDAO {

	public List<HrdSearchVO> listAll() throws Exception;
	
	
	public List<FavoriteVO> getfavclass(String id) throws Exception;
	
	
	public List getapi(List list);

}
