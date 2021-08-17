package com.web.alljobgo.calendar.domain;

public class FavoriteVO {
	private int class_Num;
	private String id;
	private String fav_classId;
	private String fav_classDegr;
	private String fav_academyId;
	
	public int getClass_Num() {
		return class_Num;
	}
	public void setClass_Num(int class_Num) {
		this.class_Num = class_Num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFav_classId() {
		return fav_classId;
	}
	public void setFav_classId(String fav_classId) {
		this.fav_classId = fav_classId;
	}

	public String getFav_classDegr() {
		return fav_classDegr;
	}
	public void setFav_classDegr(String fav_classDegr) {
		this.fav_classDegr = fav_classDegr;
	}
	public String getFav_academyId() {
		return fav_academyId;
	}
	public void setFav_academyId(String fav_academyId) {
		this.fav_academyId = fav_academyId;
	}
	
	
}
