package com.web.alljobgo.calendar.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.helper.HttpConnection.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import com.web.alljobgo.calendar.domain.FavoriteVO;
import com.web.alljobgo.calendar.domain.HrdSearchVO;
import com.web.alljobgo.calendar.domain.ResponseVO;
import com.web.alljobgo.calendar.persistance.CalendarDAO;

@Service
public class CalendarServiceImpl implements CalendarService {
	

	@Inject CalendarDAO dao;
	SqlSession session;
	
	@Override
	public List<FavoriteVO> getfavclass() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("S: getfavclass");
		
		return null ;
	}

	private final String base_Address = "https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_3.jsp?authKey=fz3vL2i5DVRvCVVefzcYiJVjaMb7ZFVV&returnType=XML&outType=2";
	private final RestTemplate template;
	
	public CalendarServiceImpl(RestTemplate template) {
		this.template = template;
	}


	/*https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_3.jsp?authKey=[인증키]&returnType=XML&outType=2
	 * &srchTrprId=[훈련과정ID]&srchTrprDegr=[훈련회차]&srchTorgId=[훈련기관ID]
	*/
	public List getapi(String id) throws Exception {
		System.out.println("S : getapi");
		String fav_Class,fav_CalssNum;
		
		ResponseVO tagvalue = null;
		List allfavlist = new ArrayList();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "Mozilla/5.0");
		HttpEntity httpEntity = new HttpEntity(headers);
		
		for(int i=0;i<dao.getfavclass(id).size();i++) {
			
			StringBuilder addurl  = new StringBuilder();
			addurl.append(base_Address);
			addurl.append("&srchTrprId=");
			addurl.append(dao.getfavclass(id).get(i).getFav_class().toString());
			addurl.append("&srchTrprDegr=");
			addurl.append(dao.getfavclass(id).get(i).getFav_classNum().toString());
			URI requrl = new URI(addurl.toString());
			
			System.out.println("url : " + addurl);
			
			tagvalue =  template.exchange(requrl, HttpMethod.GET, httpEntity, ResponseVO.class).getBody();
			
			HrdSearchVO fvo = new HrdSearchVO();
			fvo.setTrEndDt(tagvalue.getScn_list().getTrEndDt());
			fvo.setTrprDegr(tagvalue.getScn_list().getTrprDegr());
			fvo.setTrprId(tagvalue.getScn_list().getTrprId());
			fvo.setTrprNm(tagvalue.getScn_list().getTrprNm());
			fvo.setTrStaDt(tagvalue.getScn_list().getTrStaDt());
			
			allfavlist.add(fvo);
		}

		return allfavlist;
	}

}
