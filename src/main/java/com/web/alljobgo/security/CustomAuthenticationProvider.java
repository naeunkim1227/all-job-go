package com.web.alljobgo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.web.alljobgo.user.domain.userVO;
import com.web.alljobgo.user.service.HrdUserService;

@Component("CustomProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	private final HrdUserService hrdUserService;
	private final PasswordEncoder passwordEncoder;
	
	public CustomAuthenticationProvider(
			@Qualifier("HrdUserService") HrdUserService hrdUserService,
			@Qualifier("passwordEncoder") PasswordEncoder passwordEncoder
			) {
		this.hrdUserService = hrdUserService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		logger.info(authentication.toString());
		String loginUsername = authentication.getPrincipal().toString();
		String loginPassword = authentication.getCredentials().toString();
		
		userVO vo = (userVO) hrdUserService.loadUserByUsername(loginUsername);
		
		if(isMatchedPassword(loginPassword, vo.getPassword())) {
			
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	private boolean isMatchedPassword(String loginPassword, String originPassword) {
		return passwordEncoder.matches(loginPassword, originPassword);
	}
}
