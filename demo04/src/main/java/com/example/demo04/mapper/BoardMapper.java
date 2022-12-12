package com.example.demo04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo04.dto.BoardDTO;

// legacy의 xml파일 scan역할을 하는 어노테이션
@Mapper
public interface BoardMapper {

	// 추가
	@Insert("insert into board(title, writer, content) values (#{title}, #{writer}, #{content})")
	public void insert(BoardDTO board);
	
	// 전체보기
	@Select("select * from board")
	public List<BoardDTO> list();
	
	// 상세보기
	@Select("select * from board where num=#{num}")
	public BoardDTO findByNum(int num);
	
	// 개수
	@Select("select count(*) from board")
	public int getCount();
	
	// 수정
	public void update(BoardDTO board);
	
	// 삭제
	@Delete("delete from board where num=#{num}")
	public void delete(int num);

	// increase replyCnt
	@Update("update board set replycnt=replycnt+#{amount} where num=#{bnum}")
	public void updateReplyCnt(@Param("bnum")int bnum, 
			@Param("amount") int amount);
}
