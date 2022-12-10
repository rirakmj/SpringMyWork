package com.example.demo06.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo06.model.Board;
import com.example.demo06.model.User;
import com.example.demo06.repository.BoardRepository;

@Transactional(readOnly = true)
@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void insert(Board board, User user) {
		board.setUser(user);
		boardRepository.save(board);
	}

	// 전체 보기
//public List<Board> findAll() {
//	return boardRepository.findAll();
// }
// 페이징 포함 전체 보기
//	public Page<Board> findAll(Pageable pageable) {
//		return boardRepository.findAll(pageable);
//	}
	
	public Page<Board> findAll(String field, String word, Pageable pageable) {
		Page<Board> lists = boardRepository.findAll(pageable); // 검색 없을 때
		if(field.equals("title")) {
			lists = boardRepository.findByTitleContaining(word, pageable); // containing = sql문 like
		} else if (field.equals("content")) {
			lists = boardRepository.findByContentContaining(word,pageable);
		}
		return lists;
	}

	public Long count() {
		return boardRepository.count();
	}
	
	public Long count(String field, String word) {
		Long count = boardRepository.count(); // 검색 없을 때
		if(field.equals("title")) {
			count = boardRepository.cntTitleSearch(word); // containing = sql문 like
		} else if (field.equals("content")) {
			count = boardRepository.cntContentSearch(word);
		}
		return boardRepository.count();
	}

	@Transactional
	public Board findById(Long num) {
		Board board = boardRepository.findById(num).get();
		board.setHitcount(board.getHitcount() + 1);
		return board;
	}

	public Board detail(Long num) {
		return boardRepository.findById(num).get();
	}
	
	@Transactional
	public void update(Board board) {
		Board b = boardRepository.findById(board.getNum()).get();
		b.setTitle(board.getTitle());
		b.setContent(board.getContent());
		b.setRegdate(new Date());
	}
	
	@Transactional
	public void delete(Long num) {
		boardRepository.deleteById(num);
		// boardRepository.deleteByNum(num);
	}
}
