package hello.hellospring.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hello.hellospring.model.TestMember;
import hello.hellospring.repository.MemberRepository;

@Service
public class UserDService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TestMember user = memberRepository.findByUsername(username);
		if(user==null) {
			return null;
		}
		UserD duser = new UserD(user);
		return duser;
	}

}
