package com.myspring.model;

import java.util.List;

import com.myspring.vo.PersonVO;

public interface PersonService {
	// insert
	public void insert(PersonVO person);
	// overview
	public List<PersonVO> listAll();
	public List<PersonVO> list(String field, String word); // for search
	// detailview
	public PersonVO view(String id);
	// update
	public void update(PersonVO person);
	// delete
	public void delete(String id);
	// count
	public int countAll();
	public int count(String field, String word); // for search
}
