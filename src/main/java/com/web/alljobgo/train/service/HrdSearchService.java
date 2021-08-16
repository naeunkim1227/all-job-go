package com.web.alljobgo.train.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.web.alljobgo.train.domain.SearchVO;
import com.web.alljobgo.train.domain.WishVO;

public interface HrdSearchService {
	public String search(SearchVO searchVO) throws Exception;
	public JSONObject getUserWish(List<String> searchWishs , String userID);
	public JSONObject insertWish(WishVO wishVO) throws Exception;
	public JSONObject deleteWish(WishVO wishVO) throws Exception;
}
