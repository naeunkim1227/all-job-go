package com.web.alljobgo.user.persistance;

import com.web.alljobgo.user.domain.userVO;

public interface UserDAO {
	public boolean joinUser(userVO vo) throws Exception;
	public boolean isExistUser() throws Exception;
}
