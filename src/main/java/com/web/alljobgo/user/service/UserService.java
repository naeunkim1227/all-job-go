package com.web.alljobgo.user.service;

import org.json.simple.JSONObject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.web.alljobgo.user.domain.userVO;

public interface UserService {
	public boolean joinUser(userVO vo) throws Exception;
	public boolean isExistByEmail(String Email) throws Exception;
	public JSONObject isExistByEmailJson(String Email) throws Exception;
}
