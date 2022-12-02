package com.mysecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysecurity.dto.BoardDTO;
import com.mysecurity.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper bmapper;

	// add
	public void insert(BoardDTO board) {
		bmapper.insert(board);
	}
	
	// overview
		public List<BoardDTO> list() {
		return bmapper.list();
		}
	// count
		public int count() {
		return bmapper.count();
		}
	// detail
		public BoardDTO findByNum(int num) {
			return bmapper.findByNum(num);
		}
	// update
		public void update(BoardDTO board) {
		bmapper.update(board);
		}
	// delete
		public void delete(int num) {
		bmapper.delete(num);
		}		
}
		
