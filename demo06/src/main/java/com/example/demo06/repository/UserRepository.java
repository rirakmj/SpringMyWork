package com.example.demo06.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo06.model.User;

public interface UserRepository 
	extends JpaRepository<User, Long> {
	
	User findByUsername(String username); // id처럼 기본키가 아닌 것들은 작성해줘야 함, 이름만으로도 쿼리 생성이 가능함.

}
