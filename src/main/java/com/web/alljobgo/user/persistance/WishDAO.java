package com.web.alljobgo.user.persistance;

import java.util.List;

import org.json.simple.JSONObject;

import com.web.alljobgo.object.ResultType;
import com.web.alljobgo.train.domain.WishVO;

public interface WishDAO {
	public List<String> getUserWishs(WishVO wishVO);
	public ResultType insertWish(WishVO wishVO);
	public ResultType deleteWish(WishVO wishVO);
}
