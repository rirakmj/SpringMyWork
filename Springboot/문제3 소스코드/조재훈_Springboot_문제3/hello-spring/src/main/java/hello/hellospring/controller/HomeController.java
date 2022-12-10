package hello.hellospring.controller;

import java.util.List;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.hellospring.model.TestMember;
import hello.hellospring.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:list";
	}
	
	@GetMapping("login")
	public void login() {
	}
	
	@GetMapping("join")
	public String join() {
		return "join";
	}
	
	@PostMapping("join")
	public String join(TestMember member) {
		memberService.save(member);
		return "redirect:/list";
	}

	@GetMapping("list")
	public String list(Model model) {
		List<TestMember> lists = memberService.list();
		model.addAttribute("lists", lists);
		return "list";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		return "detail";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		return "update";
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public Long delete(@PathVariable Long id) {
		memberService.delete(id);
		return id;
	}

	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody TestMember member) {
		memberService.update(member);
		return "success";
	}
	
	

}
