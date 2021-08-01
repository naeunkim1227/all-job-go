package com.web.alljobgo.train.service;

import org.springframework.http.ResponseEntity;

import com.web.alljobgo.train.domain.SearchVO;

public interface HrdSearchService {
	public String search(SearchVO searchVO);
}
