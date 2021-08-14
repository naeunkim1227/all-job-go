package com.web.alljobgo.object;

public class ResultType {
	public boolean ok;
	public String error;
	
	public ResultType() {}
	public ResultType(boolean ok, String error) {
		this.ok = ok;
		this.error = error;
	}
}
