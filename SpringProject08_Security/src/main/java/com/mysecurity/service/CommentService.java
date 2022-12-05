package com.mysecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysecurity.dto.CommentDTO;
import com.mysecurity.mapper.BoardMapper;
import com.mysecurity.mapper.CommentMapper;

@Service
public class CommentService {
	@Autowired
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper;
	//�߰�
	@Transactional
	public void insert(CommentDTO comment) {
		System.out.println("bnum : " + comment.getBnum());
		bmapper.updateReplyCnt(comment.getBnum(),1);  //�ش� �Խñۿ�  replyCnt 1 ����
		cmapper.insert(comment);
	}
	//����
	@Transactional
	public void delete(int cnum) {
		CommentDTO comment = cmapper.read(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);
		cmapper.delete(cnum);
	}
	
	public List<CommentDTO> list(int bnum) {
		 return 	cmapper.list(bnum);
	}
	public int getCount(int bnum) {
		return cmapper.getCount(bnum);
	}

}
