package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDAOImpl implements GuestDAO{

	@Autowired
	private SqlSession sqlMapper;
	
	@Override
	public void dao_guestInsert(String mid, GuestDTO guest) {
		sqlMapper.insert(mid, guest);
		
	}

	@Override
	public List<GuestDTO> dao_guestList(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectList(mid,hm);
	}

	@Override
	public int dao_guestCount(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectOne(mid,hm);
	}

}
