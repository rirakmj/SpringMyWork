package com.example.demo04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo04.dto.BoardDTO;
import com.example.demo04.service.BoardService;

@Controller
public class HomeController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("login")
	public String login() {
		return "/user/login";
	}
	@GetMapping("insert")
    @PreAuthorize("isAuthenticated()")
	public String insert() {
		return "insert";
	}
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:list";
	}
	@GetMapping("list")
	public String list(Model model) {
		int count = bservice.getCount();
		model.addAttribute("count", count);
		model.addAttribute("boards", bservice.list());
		return "list";
	}
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		model.addAttribute("board", bservice.findByNum(num));
		return "view";
	}
	
}
