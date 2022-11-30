package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.FileBoardDTO;

public interface BoardService {
	
	public void insert(BoardDTO board);
	
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	
	public BoardDTO findByNum(int num);
	
	public void update(BoardDTO board);
	
	public int delete(int num);
	
	public int getCount(HashMap<String, Object>hm);
	
	public void upReadCount(int num);
	
	public void updateReplyCnt(int bnum, int amount);
	
	// ���� ���ε� �߰�
	public void fileInsert(FileBoardDTO board);
	
	// ���� ����Ʈ
	public List<FileBoardDTO> fileList();

}
