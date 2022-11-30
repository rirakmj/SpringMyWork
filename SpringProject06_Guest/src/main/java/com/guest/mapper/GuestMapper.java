package com.guest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.guest.model.GuestVO;

public interface GuestMapper {

	
	
	// �߰�
	@Insert("insert into guest(name,content,grade,created,ipaddr)  "
	+ "values(#{name}, #{content}, #{grade}, now(), #{ipaddr})")
	public void insert(GuestVO guest);
	
	// ��ü����
	// @Select("select * from guest")
	public List<GuestVO> list(HashMap<String, String> hm);
	
	// ����
	// @Select("select count(*) from guest")
	public int count(HashMap<String, String> hm);
	
	// �󼼺���
	@Select("select * from guest where num=#{num}")
	public GuestVO findByNum(int num);
	
	// ����
	@Delete("delete from guest where num=#{num}")
	public void delete(int num);




}
