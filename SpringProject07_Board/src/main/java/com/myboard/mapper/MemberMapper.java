package com.myboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myboard.dto.MemberDTO;

public interface MemberMapper {
	
	@Insert("insert into member values(#{id}, #{name}, #{pass}, #{addr}, now())")
	public void join(MemberDTO member);
	
	@Select("select count(*) from member where id=#{id}")
	public int idCheck(String id);
	
	@Select("select * from member where id=#{id}")
	public MemberDTO loginCheck(String id);
	
	@Update("update member set pass=#{pass}, addr=#{addr}, regdate=now() where id=#{id}")
	public void update(MemberDTO member);

}
