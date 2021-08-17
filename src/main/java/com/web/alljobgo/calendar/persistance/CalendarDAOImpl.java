package com.web.alljobgo.calendar.persistance;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.web.alljobgo.calendar.domain.FavoriteVO;
import com.web.alljobgo.calendar.domain.HrdSearchVO;

@Component
public class CalendarDAOImpl implements CalendarDAO{
	
	@Inject 
	private SqlSession sqlsession;
	
	
	private final static String namespace = "com.web.alljobgo.mapper.CalendarMapper";
	
	@Override
	public List<HrdSearchVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FavoriteVO> getfavclass(String id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DAO : getfavclass");
		System.out.println("DAO : id확인" + id);
		
		return sqlsession.selectList(namespace + ".getfavclass", id);
	}

	@Override
	public List getapi(List favlist) {
		System.out.println("List 잘?" + favlist);
		
		return null;
	}
	
	
	

	
	
}
