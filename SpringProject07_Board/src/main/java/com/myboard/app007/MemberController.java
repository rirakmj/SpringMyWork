package com.myboard.app007;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.MemberDTO;
import com.myboard.model.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@GetMapping("join")
	public void join() {
		
	}
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberDTO member) {
		int cnt = mservice.idCheck(member.getId()); //���̵��ߺ�Ȯ��
		if(cnt != 0 ) return "fail";  //���̵� �ߺ�
		mservice.join(member);
		return "success";	
	}
	@GetMapping("login")
	public void login() {
		
	}
	@PostMapping("login")
	@ResponseBody
	public String login(@RequestBody MemberDTO user, HttpSession session) {
		MemberDTO member = mservice.loginCheck(user.getId());
		if(member == null) { //ȸ���� �ƴ�
			return "no";
		}
		if(user.getPass().equals(member.getPass())) { //ȸ��(��� ����)
			session.setAttribute("sMember", member);
			return "success";
		}else { //��� Ʋ��
			return "pError";
		}
		
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}
	@GetMapping("update")
	public void update() {
		
	}
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody MemberDTO member,
			HttpSession session) {
		mservice.update(member);
		session.invalidate();
		return "success";	
	}

}
