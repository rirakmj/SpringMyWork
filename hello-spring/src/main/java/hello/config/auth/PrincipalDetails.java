package hello.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hello.model.Member;
import hello.repository.MemberRepository;

@Service
public class PrincipalDetails implements UserDetailsService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loaduserByUsername");
		Member mb = memberRepository.findByUsername(username);
		if(mb==null) return null;
		PrincipalMember pMember = new PrincipalMember(mb);
		System.out.println("pMember: "+pMember);
		return pMember;
	}

}
