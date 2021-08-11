package com.web.alljobgo.calender.persistance;

import java.util.List;
import java.util.Map;

import com.web.alljobgo.calender.domain.HrdSearchVO;
import com.web.alljobgo.calender.domain.FavoriteVO;

public interface CalenderDAO {

	public List<HrdSearchVO> listAll() throws Exception;
	
	
	public List<FavoriteVO> getfavclass(String id) throws Exception;
	
	
	public List getapi(List list);

}
