package com.web.alljobgo.review.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.web.alljobgo.train.domain.SearchVO;

@Service
public class CourseReviewServiceImpl implements CourseReviewService{

	private final String API_REVIEW = "https://www.hrd.go.kr/hrdp/co/pcobo/selectSatisfactionAjax_B.do";
	private RestTemplate restTemp = new RestTemplate();
	

	public CourseReviewServiceImpl(RestTemplate restTemplate) {
		this.restTemp = restTemplate;
	}

	
	@Override
	public String review(String conId) throws Exception {
		
		
		
		StringBuilder all = new StringBuilder();
		all.append(API_REVIEW);
		all.append("?tracseId=");
		all.append(conId);
		all.append("&srchTracseTme=1");
		
		System.out.println(" "
				+ "https://www.hrd.go.kr/hrdp/co/pcobo/selectSatisfactionAjax_B.do"
				+ "?tracseId="
				+ "AIG20200000294161"
				+ "&srchTracseTme=1");
		System.out.println("서비스@@@@@@@@@@@@@");
		System.out.println(conId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("User-Agent", "Mozilla/5.0");
		
		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(headers);
		
		return restTemp.exchange(all.toString(), HttpMethod.GET, httpEntity, String.class).getBody();
	}



}
