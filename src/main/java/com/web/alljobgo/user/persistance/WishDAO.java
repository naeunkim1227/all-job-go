package com.web.alljobgo.user.persistance;

import com.web.alljobgo.object.ResultType;
import com.web.alljobgo.train.domain.WishVO;

public interface WishDAO {
	public ResultType insertWish(WishVO wishVO); 
}
