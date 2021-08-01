package com.web.alljobgo.train;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public TrainSearchController(HrdSearchService hrdSearchService) {
		this.hrdSearchService = hrdSearchService;
	}
	
	@GetMapping(value = "")
	public String getSearch() {
		logger.info("getSearch");
		return "search/searchTrain";
	}
	
	@GetMapping(value="/api/hrd", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<String> getAPIData(Model model, SearchVO searchVO) throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		String curBody = mapper.writeValueAsString(hrdSearchService.search(searchVO).getBody());
		
		return hrdSearchService.search(searchVO);
	}
}
