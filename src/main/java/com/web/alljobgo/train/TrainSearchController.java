package com.web.alljobgo.train;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/search")
public class TrainSearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainSearchController.class);
	
	@GetMapping(value = "/")
	public String getSearch() {
		logger.info("getSearch");
		return "search/searchTrain";
	}
}
