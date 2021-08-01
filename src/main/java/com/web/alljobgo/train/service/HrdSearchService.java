package com.web.alljobgo.train.service;

import org.springframework.http.ResponseEntity;

import com.web.alljobgo.train.domain.SearchVO;

public interface HrdSearchService {
	public ResponseEntity<String> search(SearchVO searchVO);
}
