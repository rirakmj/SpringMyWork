package com.example.demo05.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo05.model.JpaMember;
import com.example.demo05.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	// add
	public void save(JpaMember member) {
		memberRepository.save(member);
	}
	
	// list
	public List<JpaMember> list() {
		return memberRepository.findAll();
	}
	
	// detail(optional) select * from jpa_member where id=?
	public JpaMember detail(Long id) {
		return memberRepository.findById(id).get();
	}
	
	// delete
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	// update(dirty checking)
	@Transactional
	public void update(JpaMember member) {
		// memberRepository.update(member); update는 없음
		JpaMember m = memberRepository.findById(member.getId()).get();
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setName(member.getName());
		m.setPassword(member.getPassword());
	}
}
