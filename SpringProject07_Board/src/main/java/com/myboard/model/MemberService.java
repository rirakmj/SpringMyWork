package com.myboard.model;

import com.myboard.dto.MemberDTO;

public interface MemberService {
	//�߰�
	public void join(MemberDTO member);
	
	// ���̵��ߺ�Ȯ��
	public int idCheck(String id);
	
	// �α���üũ
	public MemberDTO loginCheck(String id);
	//����
	public void update(MemberDTO member);
}
