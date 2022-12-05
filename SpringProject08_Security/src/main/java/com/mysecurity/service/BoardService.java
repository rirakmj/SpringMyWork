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
	//�߰�
	public void insert(BoardDTO board) {
		bmapper.insert(board);
	}

	//��ü����
	public List<BoardDTO> list(){
		return bmapper.list();
	}
	//����
	public int getCount() {
		return bmapper.getCount();
	}
	//�󼼺���
	public BoardDTO findByNum(int num) {
		return bmapper.findByNum(num);
	}
	

}
