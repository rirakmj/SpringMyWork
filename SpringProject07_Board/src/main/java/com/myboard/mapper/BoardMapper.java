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
	
	// �߰�
		@Insert("insert into board(title,writer,content,regdate)  "
		+ "values(#{title}, #{writer}, #{content}, now())")
	public void insert(BoardDTO board);
		
	// ��ü ����
		// @Select("select * from board") -> mapper.xml��
	public List<BoardDTO> findall(HashMap<String, Object> hm);
	
	// ����
		// @Select("select count(*) from board") -> mapper.xml��
	public int getcount(HashMap<String, Object> hm);
	
	// �� ����
		@Select("select * from board where num=#{num}")
	public BoardDTO findbynum(int num);
		
	// ����
		@Delete("delete from board where num=#{num}")
	public int delete(int num);

		// ����
//		@Update("update board set title=#{title}, content=#{content}, regdate=sysdate where num=#{num}")
	public void update(BoardDTO board);
		
	// ��� �� ����
	public void updateReplyCnt(@Param("bnum") int bnum, 
			@Param("amount") int amount);

	// ��ȸ��
	@Update("update board set hitcount=hitcount+1 where num=#{num}")
	public void upReadCount(int num);

	// ���� ���ε� �߰�
	@Insert("insert into fileboard(title, writer, content, fileimage) values(#{title}, #{writer}, #{content}, #{fileimage})")
	public void fileInsert(FileBoardDTO fboard);
	
	// ���� ����Ʈ
	@Select("select * from fileboard")
	public List<FileBoardDTO> fileList();
}
