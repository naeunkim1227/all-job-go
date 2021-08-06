package com.web.alljobgo.calender.domain;

public class FavoriteVO {
	private int class_Num;
	private int academy_Num;
	private String id;
	private String fav_class;
	private String fav_academy;
	
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
	public String getFav_class() {
		return fav_class;
	}
	public void setFav_class(String fav_class) {
		this.fav_class = fav_class;
	}
	public int getAcademy_Num() {
		return academy_Num;
	}
	public void setAcademy_Num(int academy_Num) {
		this.academy_Num = academy_Num;
	}
	public String getFav_academy() {
		return fav_academy;
	}
	public void setFav_academy(String fav_academy) {
		this.fav_academy = fav_academy;
	}
	
	@Override
	public String toString() {
		return "FavoriteVO [class_Num=" + class_Num + ", id=" + id + ", fav_class=" + fav_class + "]";
	}
	
	
}
