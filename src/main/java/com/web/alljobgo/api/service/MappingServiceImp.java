package com.web.alljobgo.api.service;

import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service("DataMapperService")
public class MappingServiceImp implements MappingService{
	@Override
	public JSONObject getSignEvent() throws Exception {
		ClassPathResource resource = new ClassPathResource("json/signEvent.json");
		return (JSONObject) new JSONParser().parse(new InputStreamReader(resource.getInputStream(),"UTF-8"));
	}
}
