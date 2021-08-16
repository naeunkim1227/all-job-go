package com.web.alljobgo.train.service;

import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.web.alljobgo.object.ResultType;
import com.web.alljobgo.train.domain.SearchVO;
import com.web.alljobgo.train.domain.WishVO;
import com.web.alljobgo.train.util.QueryStringBuilder;
import com.web.alljobgo.user.persistance.WishDAO;

@Service("searchSubject")
public class HrdSearchTotalService implements HrdSearchService {
	
	private static final Logger logger = LoggerFactory.getLogger(HrdSearchTotalService.class);
	
	@Value("${HRD_API_KEY}")
	private String API_KEY;
	private final String API_ENDPOINT = "https://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp";
	private String baseParams = "&returnType=XML&outType=1&pageNum=1&pageSize=20&sort=ASC&sortCol=TOT_FXNUM";
	private final RestTemplate restTemplate;
	private final WishDAO wishDAO;
	
	public HrdSearchTotalService(
			RestTemplate restTemplate,
			WishDAO wishDAO
			) {
		this.restTemplate = restTemplate;
		this.wishDAO = wishDAO;
	}
	
	@Override
	public String search(SearchVO searchVO) throws Exception {
		StringBuilder totalQuery = new StringBuilder();
		totalQuery.append(API_ENDPOINT);
		totalQuery.append("?authKey=");
		totalQuery.append(API_KEY);
		//totalQuery.append(baseParams);
		searchVO.setReturnType("XML");
		searchVO.setOutType("1");
		searchVO.setPageNum("1");
		searchVO.setPageSize("20");
		searchVO.setSort("ASC");
		searchVO.setSortCol("TOT_FXNUM");
		totalQuery.append(QueryStringBuilder.searchVOQuery(searchVO));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "Mozilla/5.0");
		
		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(headers);
		System.out.println(totalQuery.toString());
		return restTemplate.exchange(totalQuery.toString(), HttpMethod.GET, httpEntity, String.class).getBody();
	}

	@Override
	public JSONObject insertWish(WishVO wishVO) throws Exception {
		logger.info("insertWish! ==> {}", wishVO);
		ResultType dbResult = wishDAO.insertWish(wishVO);
		return dbResult.getJsonFormat(); 
	}
}
