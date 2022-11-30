package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.MemberDTO;
import com.myboard.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper mMapper;
	@Override
	public void join(MemberDTO member) {
		mMapper.join(member);
	}

	@Override
	public int idCheck(String id) {
		return 0;
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberDTO> member(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberDTO loginCheck(String id) {
		return mMapper.loginCheck(id);
	}
	@Override
	public void update(MemberDTO member) {
		mMapper.update(member);
		
	}
	
}
