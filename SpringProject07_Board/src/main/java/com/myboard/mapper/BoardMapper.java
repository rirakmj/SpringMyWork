package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.FileBoardDTO;

public interface BoardMapper {
	//�߰�
	@Insert("insert into board(title, writer, content) values(#{title}, #{writer},#{content})")
	public void insert(BoardDTO board);
	
	//@Select("select * from board")
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
 
	// @Select("select count(*) from board")
	 public int getCount(HashMap<String, Object> hm);

    //�󼼺���
	 @Select("select * from board where num=#{num}")
	  public BoardDTO findByNum(int num);
	 //����
	 @Delete("delete from board where num=#{num}")
	 public void delete(int num);
	 //����
	public void update(BoardDTO board) ;
	//��� ��  ����
	public void updateReplyCnt(@Param("bnum") int bnum,
			@Param("amount")  int amount);
	//��ȸ�� ����
	@Update("update board set hitcount= hitcount+1 where num=#{num}")
	public void upReadCount(int num);
	
	//���� ���ε� �߰�
	@Insert("insert into fileboard(title, writer,content, fileimage)"
			+ "  values(#{title}, #{writer},#{content},#{fileImage})")
	public void fileInsert(FileBoardDTO fboard);
	
	//���� ����Ʈ
	@Select("select * from fileboard")
	public List<FileBoardDTO>  fileList();

	
	
	
}
