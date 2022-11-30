package com.mysecurity.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccess implements AuthenticationSuccessHandler{

	@Autowired
	private PasswordEncoder passwordEncoder; // bcryptPasswordEncoder로 만들어도 PasswordEncoder가 상위 개념이므로 유형 주입 가능
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		String encPwd = passwordEncoder.encode(request.getParameter("password"));
	    System.out.println("password:" + encPwd);
		List<String> roleNames = new ArrayList<>();
		authentication.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
		System.out.println("roleNames:" + roleNames);
		
	}

}
