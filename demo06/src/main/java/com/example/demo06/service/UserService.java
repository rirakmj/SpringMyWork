package com.example.demo06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;

@Transactional(readOnly = true)
@Service
public class UserService {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserRepository userRepository;
	
	// register
	@Transactional
	public void register(User user) {
		// 비번 암호화 시키고 추가해야 함
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword); // 암호화 된 비번
		user.setRole("ROLE_USER");
		// userRepository
		userRepository.save(user);
	}
	
	public User detail(Long Id) {
		return userRepository.findById(Id).get();
	}
	@Transactional
	public void update(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword); // 암호화 된 비번
		user.setRole("ROLE_USER");
		User u = userRepository.findById(user.getId()).get();
		u.setEmail(user.getEmail());
	}
}
