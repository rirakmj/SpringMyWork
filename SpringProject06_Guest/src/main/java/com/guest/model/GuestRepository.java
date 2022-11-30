package com.guest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestRepository {

			// insert
			public void dao_guestInsert(GuestVO person);
			// overview
			public List<GuestVO> dao_guestList(HashMap<String, String> hm); // for search
			// count
			public int dao_guestCount(HashMap<String, String> hm); // for search
			// detailview
			public GuestVO dao_findByNum(int num);
			// update
			public void dao_guestUpdate(GuestVO person);
			// delete
			public void dao_guestDelete(int num);
			
			
		}
