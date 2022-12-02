package com.mysecurity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysecurity.dto.BoardDTO;

public interface BoardMapper {

	// add insert()
		@Insert("insert into board(title,writer,content,regdate)  "
			+ "values(#{title}, #{writer}, #{content}, now())")
		public void insert(BoardDTO board);
	// overview list()
		@Select("select * from board")
		public List<BoardDTO> list();
	// counting
		@Select("select count(*) from board")
		public int count();

	// detail findByNum()
		@Select("select * from board where num=#{num}")
		public BoardDTO findByNum(int num);
		
	// update
		@Update("update board set title=#{title}, content=#{content}, regdate=now() where num=#{num}")
		public void update(BoardDTO board);

		// delete
		@Delete("delete from board where num=#{num}")
		public void delete(int num);
		
		// 댓글 개수 증감 
		@Update("update board set replyCnt = replyCnt+#{amount} where num=#{bnum}")
		public void updateReplyCnt(@Param("bnum") int bnum, 
				@Param("amount") int amount);


}

	
