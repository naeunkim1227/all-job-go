package com.web.alljobgo.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.alljobgo.object.ResultType;
import com.web.alljobgo.train.TrainSearchController;
import com.web.alljobgo.user.domain.userVO;
import com.web.alljobgo.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserInfoController {
	
private static final Logger logger = LoggerFactory.getLogger(TrainSearchController.class);
	
	UserService userService;
	
	public UserInfoController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/login")
	public String getLogin() {
		logger.info("getLogin");
		return "member/login";
	}

	@GetMapping(value = "/signup")
	public String getSignUp() {
		logger.info("getSignUp");
		return "member/signup";
	}
	
	@PostMapping(value = "/signup")
	public String postSignUp(userVO vo, @RequestParam(value = "pass1", required = true) String passConfirm) throws Exception {
		logger.info("postSignUp 호출");
		logger.info("userVO 값 => {}",vo.toString());
		logger.info("비밀번호 확인 => {}",passConfirm);
		
		ResultType result = userService.joinUser(vo, passConfirm);
		if(!result.ok) {
			logger.info(result.error);
			return "redirect:../main";
		}
		logger.info("회원가입 성공");
		return "redirect:../main";
	}
}
