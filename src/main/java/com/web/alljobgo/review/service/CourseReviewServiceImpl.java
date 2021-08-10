package com.web.alljobgo.review.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.web.alljobgo.train.domain.SearchVO;

@Service
public class CourseReviewServiceImpl implements CourseReviewService{

	private final String API_REVIEW = "https://www.hrd.go.kr/hrdp/co/pcobo/selectSatisfactionAjax_B.do";
//	private String baseParams = "AIG20200000294161&srchTracseTme=1";
	private final RestTemplate restTemp;
	
	private final String API_URL = "https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp?"
								 + "p5qsxpV2BRuZtI8BLys0OBX7oMP8OzmO"
								 + "&returnType=XML&outType=1&pageNum=1&pageSize=20&sort=ASC&sortCol=TOT_FXNUM";
	
	private String A;
	

	
	public CourseReviewServiceImpl(RestTemplate restTemplate) {
		this.restTemp = restTemplate;
	}

	private static String getTagValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node)nList.item(0);
		
		return nValue.getNodeValue();
	}
	
	public void main (String[] args) throws Exception {
		
			List<Map<String, String>> list = null;
			
			String url = "https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp?authKey=p5qsxpV2BRuZtI8BLys0OBX7oMP8OzmO&returnType=XML&outType=1&pageNum=1&pageSize=20&srchTraStDt=20141001&srchTraEndDt=20141231&sort=ASC&sortCol=TOT_FXNUM";
			DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			
			
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("scn_list");
			
			for(int i =0;i<nList.getLength(); i++) {
				Map<String, String> map = new HashMap<String, String>();
				Node nNode = nList.item(i);
				Element element = (Element)nNode;
				
				
				A = map.put("trainCd", getTagValue("trprId", element));
				
				
				map.put("trainTitle", getTagValue("title", element));
				map.put("acadTitle", getTagValue("subTitle", element));
				
				list.add(map);
				
			}
	

	}
	
	
	
	@Override
	public String review(SearchVO searchVO) throws Exception {
		
		
		
		
		
		StringBuilder all = new StringBuilder();
		all.append(API_REVIEW);
		all.append("?tracseId=");
		all.append(A);
		all.append("&srchTracseTme=1");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("User-Agent", "Mozilla/5.0");
		
		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(headers);
		
		return restTemp.exchange(all.toString(), HttpMethod.GET, httpEntity, String.class).getBody();
	}



}
