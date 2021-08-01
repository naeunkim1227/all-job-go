package com.web.alljobgo.train.util;

import java.lang.reflect.Field;

import com.web.alljobgo.train.domain.SearchVO;

public class QueryStringBuilder {
	public static StringBuilder searchVOQuery(SearchVO searchVO) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder builder = new StringBuilder();
		Field[] fields = searchVO.getClass().getDeclaredFields();
		
		for(int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			builder.append("&");
			builder.append(fields[i].getName());
			builder.append("=");
			String temp = fields[i].get(searchVO) == null ? "" : fields[i].get(searchVO).toString();
			builder.append(temp);
		}
		return builder;
	}
}
