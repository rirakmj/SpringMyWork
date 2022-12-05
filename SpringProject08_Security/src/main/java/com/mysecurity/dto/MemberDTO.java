package com.mysecurity.dto;

import java.util.List;

import lombok.Data;
@Data
public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private String regDate;
	private String updateDate;
	private boolean enabled;
	private List<AuthDTO> authList;
}
