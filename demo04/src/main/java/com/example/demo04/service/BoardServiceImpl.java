package com.example.demo04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo04.dto.BoardDTO;
import com.example.demo04.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper bMapper;
	
	@Override
	public void insert(BoardDTO board) {
		bMapper.insert(board);		
	}

	@Override
	public List<BoardDTO> list() {
		return bMapper.list();
	}

	@Override
	public BoardDTO findByNum(int num) {
		return bMapper.findByNum(num);
	}
	
	@Override
	public int getCount() {
		return bMapper.getCount();
	}

	@Override
	public void update(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	

}
