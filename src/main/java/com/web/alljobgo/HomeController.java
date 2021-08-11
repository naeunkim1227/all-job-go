package com.web.alljobgo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.alljobgo.user.adapter.userAdapter;
import com.web.alljobgo.user.domain.userVO;
import com.web.alljobgo.user.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private final UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value={"","/","/main"})
	public void main() {
	}
}
