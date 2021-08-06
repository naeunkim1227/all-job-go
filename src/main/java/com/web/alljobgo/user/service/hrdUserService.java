package com.web.alljobgo.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.alljobgo.user.domain.userVO;
import com.web.alljobgo.user.persistance.UserDAO;

@Service
public class hrdUserService implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(hrdUserService.class);
	private UserDAO userDAO;
	
	public hrdUserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean joinUser(userVO vo) throws Exception {
		logger.info("hrdUserService ==> joinUser");
		
		if(!userDAO.joinUser(vo)) {
			return false;
		}
		return true;
	}

}
