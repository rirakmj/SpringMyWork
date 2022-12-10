package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.model.Member;

public interface MemberRepository 
	extends JpaRepository<Member, Long> {
		
	Member findByUsername(String username);
	}
