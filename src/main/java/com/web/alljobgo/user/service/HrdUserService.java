package com.web.alljobgo.user.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.alljobgo.user.domain.userVO;
import com.web.alljobgo.user.persistance.UserDAO;

@Service("HrduserService")
public class HrdUserService implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(HrdUserService.class);
	private UserDAO userDAO;
	
	public HrdUserService(UserDAO userDAO) {
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
	
	@Override
	public boolean isExistByEmail(String Email) throws Exception {
		userVO vo = userDAO.findByEmail(Email);
		return vo == null ? false : true;
	}
	
	@Override
	public JSONObject isExistByEmailJson(String Email) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject getEmail = (JSONObject) parser.parse(Email);
		
		Map<String, Boolean> obj = new HashMap<String, Boolean>();
		obj.put("exist", isExistByEmail((String) getEmail.get("userEmail")));
		
		return new JSONObject(obj);
	}
}
