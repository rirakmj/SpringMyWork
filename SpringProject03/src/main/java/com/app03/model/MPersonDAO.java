package com.app03.model;

import java.util.List;

public interface MPersonDAO {
	
	// insert
	public void person_insert(PersonDTO person);
	
	// list
	public List<PersonDTO> person_list();
	
	// °³¼ö
	public int person_count();
	
	// detail
	public PersonDTO person_view(String id);
	
	// revision
	public void person_update(PersonDTO person);
	
	// deletion
	public void person_delete(String id);

}
