package com.web.alljobgo.user.persistance;

import com.web.alljobgo.user.domain.userVO;

public interface UserDAO {
	public boolean joinUser(userVO vo) throws Exception;
	public boolean joinAdmin(userVO vo) throws Exception;
	public userVO findByEmail(String Email) throws Exception;
}
