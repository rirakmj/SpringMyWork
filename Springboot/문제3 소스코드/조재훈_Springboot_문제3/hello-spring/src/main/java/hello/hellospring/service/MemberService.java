package hello.hellospring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hello.hellospring.model.TestMember;
import hello.hellospring.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private MemberRepository memberRepository;
	
		public void save(TestMember member) {
			String rawPwd = member.getPassword();
			String encPwd = encoder.encode(rawPwd);
			member.setPassword(encPwd);
			member.setRole("ROLE_ADMIN");
			memberRepository.save(member);
		}
		public List<TestMember> list() {
			return memberRepository.findAll();
		}
		public TestMember detail(Long id) {
			return memberRepository.findById(id).get();
		}
		
		public void delete(Long id) {
			memberRepository.deleteById(id);
		}
		
		@Transactional
		public void update(TestMember member) {
		String rawPwd = member.getPassword();
		String encPwd = encoder.encode(rawPwd);
		TestMember m= memberRepository.findById(member.getId()).get();
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setUsername(member.getUsername());
		m.setPassword(encPwd);
		
		}
	
}
