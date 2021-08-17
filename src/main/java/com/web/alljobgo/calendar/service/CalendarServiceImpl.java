package com.web.alljobgo.calendar.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.helper.HttpConnection.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import com.web.alljobgo.calendar.domain.FavoriteVO;
import com.web.alljobgo.calendar.domain.HrdSearchVO;
import com.web.alljobgo.calendar.domain.HRDNetVO;
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
	public Vector getapi(String id) throws Exception {
		System.out.println("S : getapi");
		String fav_ClassId,fav_CalssDegr;
		
		HRDNetVO tagvalue = null;
		HRDNetVO tagvalue2 = null;
		List classlist = new ArrayList();
		List academylist = new ArrayList();
		Vector totallist =  new Vector();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "Mozilla/5.0");
		HttpEntity httpEntity = new HttpEntity(headers);
		
		
		for(int i=0;i<dao.getfavclass(id).size();i++) {
			
			StringBuilder addurl  = new StringBuilder();
			addurl.append(base_Address);
			addurl.append("&srchTrprId=");
			addurl.append(dao.getfavclass(id).get(i).getFav_classId().toString());
			addurl.append("&srchTrprDegr=");
			addurl.append(dao.getfavclass(id).get(i).getFav_classDegr().toString());
			
			URI requrl = new URI(addurl.toString());
			
			System.out.println("url : " + addurl);
			
			tagvalue =  template.exchange(requrl, HttpMethod.GET, httpEntity, HRDNetVO.class).getBody();
			
			for(int a=0;a<tagvalue.getScn_list().size() ;a++) {
				HrdSearchVO fvo = new HrdSearchVO();
			
				fvo.setTrEndDt(tagvalue.getScn_list().get(a).getTrEndDt());
				fvo.setTrprDegr(tagvalue.getScn_list().get(a).getTrprDegr());
				fvo.setTrprId(tagvalue.getScn_list().get(a).getTrprId());
				fvo.setTrprNm(tagvalue.getScn_list().get(a).getTrprNm());
				fvo.setTrStaDt(tagvalue.getScn_list().get(a).getTrStaDt());
	
				classlist.add(fvo);
			}
			
			////////////////////////////////////////////////////////////////////////////////
			
			StringBuilder addurl2 = new StringBuilder();
			addurl2.append(base_Address);
			addurl2.append("&srchTrprId=");
			addurl2.append(dao.getfavclass(id).get(i).getFav_classId().toString());
			addurl2.append("&srchTorgId=");
			addurl2.append(dao.getfavclass(id).get(i).getFav_academyId().toString());
			
			URI requrl2 =  new URI(addurl2.toString());
			System.out.println("url2 : " + requrl2 );
			
			tagvalue2 = template.exchange(requrl2, HttpMethod.GET, httpEntity, HRDNetVO.class).getBody();
			
			for(int a=1;a<tagvalue2.getScn_list().size();a++) {
			
				HrdSearchVO fvo2 = new HrdSearchVO();
				fvo2.setTrEndDt(tagvalue2.getScn_list().get(a).getTrEndDt());
				fvo2.setTrprDegr(tagvalue2.getScn_list().get(a).getTrprDegr());
				fvo2.setTrprId(tagvalue2.getScn_list().get(a).getTrprId());
				fvo2.setTrprNm(tagvalue2.getScn_list().get(a).getTrprNm());
				fvo2.setTrStaDt(tagvalue2.getScn_list().get(a).getTrStaDt());
				
				academylist.add(fvo2);
				System.out.println("확인중" + tagvalue2.getScn_list().get(a).getTrprDegr());
			}
			
			totallist.add(classlist);
			totallist.add(academylist);
		}

		return totallist;
	}




}
