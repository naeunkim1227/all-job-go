package com.web.alljobgo.train.domain;

import java.util.List;

public class WishVO {
	private int class_Num;
	private String id;
	private String fav_classId;
	private String fav_classDegr;
	private String fav_academyId;
	private List<String> classId;
	
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
	public List<String> getClassId() {
		return classId;
	}
	public void setClassId(List<String> classId) {
		this.classId = classId;
	}
	@Override
	public String toString() {
		return "WishVO [class_Num=" + class_Num + ", id=" + id + ", fav_classId=" + fav_classId + ", fav_classDegr="
				+ fav_classDegr + ", fav_academyId=" + fav_academyId + ", classId=" + classId + "]";
	}
}
