package com.web.alljobgo.review.service;


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



@Service
public class CourseReviewServiceImpl implements CourseReviewService{

	private final String API_REVIEW = "https://www.hrd.go.kr/hrdp/co/pcobo/selectSatisfactionAjax_B.do";
	private RestTemplate restTemp = new RestTemplate();
	
	
	private final String ACA_INFOR = "https://www.hrd.go.kr/hrdp/ti/ppsgo/trainListByTraceIdTracseTme.do";

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
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("User-Agent", "Mozilla/5.0");
		
		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(headers);
		
		return restTemp.exchange(all.toString(), HttpMethod.GET, httpEntity, String.class).getBody();
	}


	@Override
	public String acainfor(String conId) throws Exception {
		
		StringBuilder infor = new StringBuilder();
		infor.append(ACA_INFOR);
		infor.append("?tracseId=");
		infor.append(conId);
		infor.append("&tracse_tme=1&tracse_id=");
		infor.append(conId);
		infor.append("&tracse_tme=1");
		
		
		HttpHeaders header = new HttpHeaders();
		header.add("Accept", "application/json");
		header.add("User-Agent", "Mozilla/5.0");
		
		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(header);
		
		return restTemp.exchange(infor.toString(), HttpMethod.GET, httpEntity, String.class).getBody();
	}



}
