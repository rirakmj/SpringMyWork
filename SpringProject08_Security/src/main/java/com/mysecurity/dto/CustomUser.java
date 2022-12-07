package com.mysecurity.dto;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

// 시큐리티가 적용된 유저
@Getter @Setter
public class CustomUser extends User{
	private MemberDTO member;
	
	public CustomUser(MemberDTO vo) {
		super(vo.getUserid(),
		vo.getUserpw(),
		vo.getAuthList().stream().map(auth->new SimpleGrantedAuthority(auth.getAuth()))
		.collect(Collectors.toList())
		); // 생성자
		member = vo;
	}
}
