package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Member;
import hello.repository.MemberRepository;
import hello.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HelloController {
	private final MemberService memberService;
	private final MemberRepository memberRepository;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/board/review";
	}
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	// 회원 가입
	@GetMapping("register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("register")
	@ResponseBody
	public String register(@RequestBody Member member) {
		if(memberRepository.findByUsername(member.getUsername())!=null) {
		return "fail";
		}
		memberService.register(member);
		return "success";
	}
	
	@GetMapping("update/{Id}")
	public String update(@PathVariable Long Id, Model model) {
		model.addAttribute("member", memberService.detail(Id));
		return "/member/update";
	}
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Member member) {
		memberService.update(member);
		return "success";
	}
		
		
	}
