package com.web.alljobgo.user.service;

import org.json.simple.JSONObject;

import com.web.alljobgo.user.domain.userVO;

public interface UserService {
	public boolean joinUser(userVO vo) throws Exception;
	public boolean isExistByEmail(String Email) throws Exception;
	public JSONObject isExistByEmailJson(String Email) throws Exception;
}
