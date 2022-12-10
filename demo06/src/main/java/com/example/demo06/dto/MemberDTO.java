package com.example.demo06.dto;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private String enabled;
	private String regDate;
	private String updateDate;
	private List<AuthDTO> authList;
}
