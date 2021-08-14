package com.web.alljobgo.user.service;

import org.json.simple.JSONObject;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.web.alljobgo.object.ResultType;
import com.web.alljobgo.user.domain.userVO;

public interface UserService extends UserDetailsService{
	public ResultType joinUser(userVO vo, String passConfirm) throws Exception;
	public boolean isExistByEmail(String Email) throws Exception;
	public JSONObject isExistByEmailJson(String Email) throws Exception;
}
