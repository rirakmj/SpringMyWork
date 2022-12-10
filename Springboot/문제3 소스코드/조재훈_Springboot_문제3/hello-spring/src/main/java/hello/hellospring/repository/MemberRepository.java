package hello.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.model.TestMember;

public interface MemberRepository extends JpaRepository<TestMember, Long>{
	
	TestMember findByUsername(String username);
	
}
