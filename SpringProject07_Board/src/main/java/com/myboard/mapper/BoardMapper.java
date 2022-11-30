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
	
	// 추가
		@Insert("insert into board(title,writer,content,regdate)  "
		+ "values(#{title}, #{writer}, #{content}, now())")
	public void insert(BoardDTO board);
		
	// 전체 보기
		// @Select("select * from board") -> mapper.xml로
	public List<BoardDTO> findall(HashMap<String, Object> hm);
	
	// 개수
		// @Select("select count(*) from board") -> mapper.xml로
	public int getcount(HashMap<String, Object> hm);
	
	// 상세 보기
		@Select("select * from board where num=#{num}")
	public BoardDTO findbynum(int num);
		
	// 삭제
		@Delete("delete from board where num=#{num}")
	public int delete(int num);

		// 수정
//		@Update("update board set title=#{title}, content=#{content}, regdate=sysdate where num=#{num}")
	public void update(BoardDTO board);
		
	// 댓글 수 증감
	public void updateReplyCnt(@Param("bnum") int bnum, 
			@Param("amount") int amount);

	// 조회수
	@Update("update board set hitcount=hitcount+1 where num=#{num}")
	public void upReadCount(int num);

	// 파일 업로드 추가
	@Insert("insert into fileboard(title, writer, content, fileimage) values(#{title}, #{writer}, #{content}, #{fileimage})")
	public void fileInsert(FileBoardDTO fboard);
	
	// 파일 리스트
	@Select("select * from fileboard")
	public List<FileBoardDTO> fileList();
}
