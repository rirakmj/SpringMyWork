package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import com.myspring.vo.PersonVO;

public interface PersonDAO {
	// insert
		public void dao_insert(String mid, PersonVO person);
		// overview
		public List<PersonVO> dao_listAll(String mid);
		public List<PersonVO> dao_searchlist(String mid, HashMap<String, String> hm); // for search
		// detailview
		public PersonVO dao_view(String mid, String id);
		// update
		public void dao_update(String mid, PersonVO person);
		// delete
		public void dao_delete(String mid, String id);
		// count
		public int dao_count(String mid);
		public int dao_searchcount(String mid, HashMap<String, String> hm); // for search
	}

