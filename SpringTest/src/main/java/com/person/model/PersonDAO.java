package com.person.model;

import java.util.List;

public interface PersonDAO {
	
	// insert
	public void personInsert(Person person);
	
	// list
	public List<Person> personList();
	
	// detail
	public Person personView(String id);
	
	// revision
	public void personUpdate(Person person);
	
	// deletion
	public void personDelete(String id);

}
