package com.myboard.model;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentService {
	   	public void insert(CommentDTO comment); //�߰�
		public List<CommentDTO> getList(int bnum);//��ü����
		public void delete(int cnum);	//����
}
