package com.web.alljobgo.user.adapter;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.web.alljobgo.user.domain.userVO;

public class userAdapter extends User{
	private static final long serialVersionUID = -317352754514473474L;
	private userVO vo;
	
	public userAdapter(userVO vo) {
		super(vo.getUsername(), vo.getPass(), Arrays.asList(new SimpleGrantedAuthority(vo.getAuthority())));
		this.vo = vo;
	}

	public userVO getVo() {
		return vo;
	}
}
