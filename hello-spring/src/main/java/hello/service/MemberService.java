package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.model.Member;
import hello.repository.MemberRepository;

@Transactional(readOnly = true)
@Service
public class MemberService {
		@Autowired
		private BCryptPasswordEncoder encoder;
		@Autowired
		private MemberRepository memberRepository;
		
		// register
		@Transactional
		public void register(Member member) {
			String rawPassword = member.getPassword();
			String encPassword = encoder.encode(rawPassword);
			member.setPassword(encPassword);
			// member.setRole("ROLE_ADMIN");
			member.setRole("ROLE_USER");
			memberRepository.save(member);
		}
		
		public Member detail(Long Id) {
			return memberRepository.findById(Id).get();
		}
		
		@Transactional
		public void update(Member member) {
			String rawPassword = member.getPassword();
			String encPassword = encoder.encode(rawPassword);
			member.setPassword(encPassword);
			member.setRole("ROLE_USER");
			Member m = memberRepository.findById(member.getId()).get();
			m.setEmail(member.getEmail());
			m.setAddr(member.getAddr());
		}
	}

