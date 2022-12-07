package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {
	
	// @Insert("insert into commentboard(userid, content, regdate, bnum) values(#{userid}, #{content}, now(), #{bnum}")
	public void insert(CommentDTO comment);
	public List<CommentDTO> getList(int bnum);
	public void delete(int cnum);
	
	// read
	@Select("select * from commentboard where cnum=#{cnum}")
	public CommentDTO read(int cnum);
}
