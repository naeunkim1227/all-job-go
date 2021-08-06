package com.web.alljobgo.user.domain;

public class userVO {
	private int member_Num;
	private String id;
	private String pass;
	private String name;
	private String phonenumber;
	private String address;
	private int fav_Area;
	private int fav_Cate;
	public int getMember_Num() {
		return member_Num;
	}
	public void setMember_Num(int member_Num) {
		this.member_Num = member_Num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getFav_Area() {
		return fav_Area;
	}
	public void setFav_Area(int fav_Area) {
		this.fav_Area = fav_Area;
	}
	public int getFav_Cate() {
		return fav_Cate;
	}
	public void setFav_Cate(int fav_Cate) {
		this.fav_Cate = fav_Cate;
	}
	@Override
	public String toString() {
		return "userVO [member_Num=" + member_Num + ", id=" + id + ", pass=" + pass + ", name=" + name
				+ ", phonenumber=" + phonenumber + ", address=" + address + ", fav_Area=" + fav_Area + ", fav_Cate="
				+ fav_Cate + "]";
	}
}
