package com.example.demo06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo06.model.Board;
import com.example.demo06.model.Comment;
import com.example.demo06.repository.BoardRepository;
import com.example.demo06.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void insert(Comment comment) {
		// commentRepository.save(comment);
		
		// replyCnt + 1
		Board b = boardRepository.findById(comment.getBoard().getNum()).get();
		b.setReplycnt(b.getReplycnt()+1);
		
		// native sql
		commentRepository.insert(comment.getContent(),
				comment.getBoard().getNum(),
				comment.getUser().getId());
	}
	
	public List<Comment> list(long bnum) {
		return commentRepository.findByBnum(bnum);
	}

}
