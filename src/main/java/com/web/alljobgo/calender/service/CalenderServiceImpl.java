package com.web.alljobgo.calender.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.helper.HttpConnection.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import com.web.alljobgo.calender.domain.HrdSearchVO;
import com.web.alljobgo.calender.domain.ResponseVO;
import com.web.alljobgo.calender.java.getvalue;
import com.web.alljobgo.calender.domain.FavoriteVO;
import com.web.alljobgo.calender.persistance.CalenderDAO;

@Service
public class CalenderServiceImpl implements CalenderService {
	

	@Inject CalenderDAO dao;
	SqlSession session;
	
	@Override
	public List<FavoriteVO> getfavclass() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("S: getfavclass");
		
		return null ;
	}

	private final String base_Address = "https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_3.jsp?authKey=fz3vL2i5DVRvCVVefzcYiJVjaMb7ZFVV&returnType=XML&outType=2";
	private final RestTemplate template;
	
	public CalenderServiceImpl(RestTemplate template) {
		this.template = template;
	}


	/*https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_3.jsp?authKey=[인증키]&returnType=XML&outType=2
	 * &srchTrprId=[훈련과정ID]&srchTrprDegr=[훈련회차]&srchTorgId=[훈련기관ID]
	
	*/
	public ResponseVO getapi(String id) throws Exception {
		System.out.println("S : getapi");
		System.out.println("S : getapi에서 id확인" + id);
		
		String fav_Class = dao.getfavclass(id).get(0).getFav_class().toString();
		String fav_CalssNum = dao.getfavclass(id).get(0).getFav_classNum().toString();
		
		/*for(int i=0;i<dao.getfavclass(id).size();i++) {
		}*/
		
		StringBuilder addurl  = new StringBuilder();
		addurl.append(base_Address);
		addurl.append("&srchTrprId=");
		addurl.append(fav_Class);
		addurl.append("&srchTrprDegr=1");
		//addurl.append(fav_CalssNum);
		
		System.out.println(addurl);
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "Mozilla/5.0");
		HttpEntity httpEntity = new HttpEntity(headers);
		System.out.println(template.exchange(addurl.toString(), HttpMethod.GET, httpEntity, String.class).getBody());
		
		
		URI requrl = new URI(addurl.toString());
		
		System.out.println("으에" + template.getForObject(addurl.toString(), ResponseVO.class).getScn_list());
		
		ResponseVO favlist =  template.exchange(requrl, HttpMethod.GET, httpEntity, ResponseVO.class).getBody();

		return favlist;
	}
}
