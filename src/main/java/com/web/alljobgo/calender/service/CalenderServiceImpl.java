package com.web.alljobgo.calender.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.inject.Inject;

import org.apache.http.HttpHeaders;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.alljobgo.calender.domain.HrdSearchVO;
import com.web.alljobgo.calender.domain.FavoriteVO;
import com.web.alljobgo.calender.persistance.CalenderDAO;

@Service
public class CalenderServiceImpl implements CalenderService {

	private final String base_Address1 = "https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp?authKey=fz3vL2i5DVRvCVVefzcYiJVjaMb7ZFVV&returnType=XML&outType=1&pageNum=1&pageSize=20";
	private final String base_Aderess2 = "&sort=ASC&sortCol=TR_STT_DT"; 
	
	//&srchTraStDt=20141001&srchTraEndDt=20141231&sort=ASC&sortCol=TOT_FXNUM
	
	
	RestTemplate template = new RestTemplate(); 
	

	
	@Inject CalenderDAO dao;
	SqlSession session;
	
	@Override
	public List<HrdSearchVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<FavoriteVO> getfavclass() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("S: getfavclass");
		
		return dao.getfavclass();
	}


	
	

	
}
