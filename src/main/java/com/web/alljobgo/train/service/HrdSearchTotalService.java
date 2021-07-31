package com.web.alljobgo.train.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.web.alljobgo.train.domain.SearchVO;

@Service
public class HrdSearchTotalService implements HrdSearchService {

	private final String API_KEY = "4m3FdV2kNxlMop0qg7B5WAfxgr64fMGb";
	private final String API_ENDPOINT = "https://www.hrd.go.kr/hrdp/api/apipo/APIPO0101T.do?returnType=XML&pageSize=10&sortCol=TR_STT_DT&authKey=4m3FdV2kNxlMop0qg7B5WAfxgr64fMGb&outType=1&srchTraStDt=20210731&srchTraProcessNm=java&pageNum=1&sort=ASC&srchTraEndDt=20211031&srchTraPattern=N1&srchPart=-99&apiRequstPageUrlAdres=/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp&apiRequstIp=121.175.218.134";
	private String baseParams = "?authKey="+API_KEY+"&returnType=XML&outType=2&pageNum=1&pageSize=10";
	
	private WebClient client = WebClient.builder().baseUrl(API_ENDPOINT).build();
	
	@Override
	public String search(SearchVO searchVO) {
		
		String title = "&srchTraProcessNm="+searchVO.getSrchTraProcessNm();
		return client.get().retrieve().bodyToMono(String.class).block();
	}

}
