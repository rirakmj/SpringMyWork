package com.mysecurity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mysecurity.dto.CommentDTO;

public interface CommentMapper {
	
	// add
	@Insert("insert into commentboard(userid, content, regdate, bnum) values(#{userid}, #{content}, now(), #{bnum})")
	public void insert(CommentDTO comment);

	@Select("select * from commentboard where bnum=#{bnum}")
	public List<CommentDTO> list(int bnum);
	
	@Select("select count(*) from commentboard where bnum=#{bnum}")
	public int getCount(int bnum);
	
	@Select("select * from commentboard where cnum=#{cnum}")
	public CommentDTO read(int cnum);
	
	@Delete("delete from commentboard where cnum=#{cnum}")
	public void delete(int cnum);
}
