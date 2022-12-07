package com.myboard.model;

import java.util.List;

import com.myboard.dto.MemberDTO;

public interface MemberService {
	
	public void join(MemberDTO member);
	public int idCheck(String id);
	public List<MemberDTO> member(String id);
	public MemberDTO loginCheck(String id);
	public void update(MemberDTO member);

}
