package com.web.alljobgo.train;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.alljobgo.train.domain.SearchVO;
import com.web.alljobgo.train.service.HrdSearchService;

@Controller
@RequestMapping(value = "/search")
public class TrainSearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainSearchController.class);
	private final HrdSearchService hrdSearchService;
	
	public TrainSearchController(@Qualifier("searchSubject") HrdSearchService hrdSearchService) {
		this.hrdSearchService = hrdSearchService;
	}
	
	@GetMapping(value = "")
	public String getSearch() {
		logger.info("getSearch");
		return "search/searchTrain";
	}
	
	@GetMapping(value = "/api/hrd", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE + "; charset=utf8")
	@ResponseBody
	public String getAPIData(Model model, SearchVO searchVO) throws Exception {
		return hrdSearchService.search(searchVO);
	}
}
