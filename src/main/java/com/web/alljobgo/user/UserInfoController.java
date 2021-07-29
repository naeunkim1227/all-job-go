package com.web.alljobgo.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.alljobgo.train.TrainSearchController;

@Controller
@RequestMapping("/user")
public class UserInfoController {
	
private static final Logger logger = LoggerFactory.getLogger(TrainSearchController.class);
	
	@GetMapping(value = "")
	public String getLogin() {
		logger.info("getLogin");
		return "member/login";
	}

	@GetMapping(value = "/signup")
	public String getSignUp() {
		logger.info("getSignUp");
		return "member/signup";
	}
}
