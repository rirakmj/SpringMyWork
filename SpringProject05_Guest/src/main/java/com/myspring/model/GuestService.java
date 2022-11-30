package com.myspring.model;

import java.util.HashMap;
import java.util.List;

public interface GuestService {
	
	// �߰�
	public void guestInsert(GuestDTO guest);
	// ��ü����
	public List<GuestDTO> guestList(HashMap<String, String> hm);
	// ����
	public int guestCount(HashMap<String, String> hm);

}
