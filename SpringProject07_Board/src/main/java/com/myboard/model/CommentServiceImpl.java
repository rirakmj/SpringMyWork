package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.dto.CommentDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper;
	
	@Transactional
	@Override
	public void insert(CommentDTO comment) { // 댓글 추가와 replyCnt는 같이 작동해야 한다 -> 트랜잭션
		cmapper.insert(comment); // 댓글추가
		bmapper.updateReplyCnt(comment.getBnum(), 1); // replyCnt 증가	
		}

	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Transactional
	@Override
	public void delete(int cnum) {
		CommentDTO comment = cmapper.read(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);
		cmapper.delete(cnum);
	}

}
