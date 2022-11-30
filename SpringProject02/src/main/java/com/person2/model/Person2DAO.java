package com.person2.model;

import java.util.List;

public interface Person2DAO {
	
	// insert
	public void person_insert(PersonVO person);
	
	// list
	public List<PersonVO> person_list();
	
	// detail
	public PersonVO person_view(String id);
	
	// revision
	public void person_update(PersonVO person);
	
	// deletion
	public void person_delete(String id);
	
	// count
	public int person_count();

}
