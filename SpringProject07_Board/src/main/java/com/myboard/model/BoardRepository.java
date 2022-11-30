package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.FileBoardDTO;

public interface BoardRepository {
	
	public void dao_insert(BoardDTO board);
	
	public List<BoardDTO>dao_findAll(HashMap<String, Object> hm);
	
	public BoardDTO dao_findByNum(int num);
	
	public void dao_update(BoardDTO board);
	
	public int dao_delete(int num);
	
	public int dao_getCount(HashMap<String, Object> hm);
	
	public void dao_upReadCount(int num);
	
	public void dao_updateReplyCnt(int bnum, int amount);
	
	// 파일 업로드 추가
	public void dao_fileInsert(FileBoardDTO board);

	// 파일 리스트
	public List<FileBoardDTO> dao_fileList();

}
