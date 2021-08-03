package com.web.alljobgo.review.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.alljobgo.train.domain.SearchVO;

@Service
public class CourseReviewServiceImpl implements CourseReviewService{

	private final String API_ENDPOINT = "https://www.hrd.go.kr/hrdp/co/pcobo/selectSatisfactionAjax_B.do";
	private String baseParams = "tracseId=AIG20200000294161&srchTracseTme=1";
	private final RestTemplate restTemp;
	
	public CourseReviewServiceImpl(RestTemplate restTemplate) {
		this.restTemp = restTemplate;
	}

	
	@Override
	public String review(SearchVO searchVO) throws Exception {
		StringBuilder all = new StringBuilder();
		all.append(API_ENDPOINT);
		all.append("?");
		all.append(baseParams);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("User-Agent", "Mozilla/5.0");
		
		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(headers);
		
		return restTemp.exchange(all.toString(), HttpMethod.GET, httpEntity, String.class).getBody();
	}

}
