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
	// add
	@Transactional
	public void insert(CommentDTO comment) {
		System.out.println("bnum:" + comment.getBnum());
		bmapper.updateReplyCnt(comment.getBnum(),1);
		cmapper.insert(comment);
		}
	public List<CommentDTO> list(int bnum) { // bnum 받고
		return cmapper.list(bnum); // bnum 주고
	}
public int getCount(int bnum) {
	return cmapper.getCount(bnum);
	}

@Transactional
public void delete(int cnum) {
	CommentDTO comment = cmapper.read(cnum); // cnum을 이용해서 bnum을 구해오기, read 안 쓰고 sql문 join을 써도 됨.
	bmapper.updateReplyCnt(comment.getBnum(), -1); 
	cmapper.delete(cnum);
	}
}

