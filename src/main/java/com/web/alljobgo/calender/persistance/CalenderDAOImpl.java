package com.web.alljobgo.calender.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.web.alljobgo.calender.domain.HrdSearchVO;
import com.web.alljobgo.calender.domain.FavoriteVO;

@Component
public class CalenderDAOImpl implements CalenderDAO{
	
	@Inject 
	private SqlSession sqlsession;
	
	
	private final static String namespace = "com.web.alljobgo.mapper.CalenderMapper";
	
	@Override
	public List<HrdSearchVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FavoriteVO> getfavclass() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DAO : getfavclass");
		return sqlsession.selectList(namespace + ".getfavclass");
	}
	
	
	

	
	
}
