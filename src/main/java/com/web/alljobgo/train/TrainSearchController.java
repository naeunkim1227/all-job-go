package com.web.alljobgo.train;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping(value="/api/hrd")
	public String getAPIData(Model model, SearchVO searchVO) {
		model.addAttribute(hrdSearchService.search(searchVO));
		return "search/result";
	}
}
