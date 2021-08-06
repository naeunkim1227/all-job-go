package com.web.alljobgo.user.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class hrdUserService implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(hrdUserService.class);
	
	@Override
	public boolean joinUser() throws Exception {
		logger.info("hrdUserService ==> joinUser");
		
		return false;
	}

}
