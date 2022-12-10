package com.example.demo06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;
import com.example.demo06.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final UserService userService;
	private final UserRepository userRepository;
	
//	@Autowired
//	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/board/list";
	}

	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("register")
	public String register() {
		return "/user/join";
	}
	@PostMapping("register")
	@ResponseBody
	public String join(@RequestBody User user) {
		// username이 있으면 fail을 return
		if(userRepository.findByUsername(user.getUsername())!=null) {
		return "fail";
		}
		userService.register(user);
		return "success";
	}
	@GetMapping("userupdate/{Id}")
	public String update(@PathVariable Long Id, Model model) {
		model.addAttribute("user", userService.detail(Id));
		return "/user/userupdate";
	}
	@PutMapping("userupdate")
	@ResponseBody
	public String userupdate(@RequestBody User user) {
		userService.update(user);
		return "success";
	}
	
	
}
