package com.guest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestService {

	public void guestInsert(GuestVO guest);
	
	public List<GuestVO> guestList(HashMap<String, String> hm);
	
	public GuestVO findByNum(int num);
	
	public void guestUpdate(GuestVO guest);
	
	public void guestDelete(int num);
	
	public int guestCount(HashMap<String, String> hm);

	
}
