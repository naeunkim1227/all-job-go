package com.web.alljobgo.train.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.alljobgo.train.domain.SearchVO;

@Service
public class HrdSearchTotalService implements HrdSearchService {
	private final RestTemplate restTemplate;

	
	public HrdSearchTotalService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public String search(SearchVO searchVO) {
		//restTemplate.exchange(null, null, null, null)
		
		return null;
	}

}
