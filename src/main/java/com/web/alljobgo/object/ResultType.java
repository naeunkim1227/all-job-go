package com.web.alljobgo.object;

import org.json.simple.JSONObject;

public class ResultType {
	public boolean ok;
	public String error;
	
	public ResultType() {}
	public ResultType(boolean ok, String error) {
		this.ok = ok;
		this.error = error;
	}
	
	public JSONObject getJsonFormat() {
		JSONObject retObj = new JSONObject();
		retObj.put("ok", this.ok);
		retObj.put("error", this.error);
		return retObj;
	}
}
