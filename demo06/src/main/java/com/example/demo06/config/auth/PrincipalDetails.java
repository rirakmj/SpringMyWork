package com.example.demo06.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;

@Service
public class PrincipalDetails implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loaduserByUsername");
		User user = userRepository.findByUsername(username);
		if(user==null) return null;
		// 회원이라면 시큐리티가 적용된 유저를 리턴
		PrincipalUser puser = new PrincipalUser(user);
		System.out.println("puser:"+puser);
		return puser;
	}

}
