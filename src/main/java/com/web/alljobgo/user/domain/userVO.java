package com.web.alljobgo.user.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class userVO implements UserDetails{
	private static final long serialVersionUID = 8002556700564359298L;
	
	private int member_Num;
	private String id;
	private String pass;
	private String name;
	private String authority;
	private String phonenumber;
	private String address;
	private String address_detail;
	private int fav_Area;
	private int fav_Cate;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(authority));
		return authorities;
	}
	@Override
	public String getPassword() {
		return this.pass;
	}
	@Override
	public String getUsername() {
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@Override
	public boolean isEnabled() {
		return false;
	}
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
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "userVO [member_Num=" + member_Num + ", id=" + id + ", pass=" + pass + ", name=" + name
				+ ", phonenumber=" + phonenumber + ", address=" + address + ", address_detail=" + address_detail
				+ ", fav_Area=" + fav_Area + ", fav_Cate=" + fav_Cate + "]";
	}
}
