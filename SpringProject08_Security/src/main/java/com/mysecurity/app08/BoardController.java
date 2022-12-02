package com.mysecurity.app08;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysecurity.dto.BoardDTO;
import com.mysecurity.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public void insert() {
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO board, HttpServletRequest request) {
		bservice.insert(board);
		return "redirect:list";
	}
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("count", bservice.count());
		model.addAttribute("boards", bservice.list());
		return "board/list";
	}
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		model.addAttribute("count", bservice.count());
		model.addAttribute("board", bservice.findByNum(num));
		return "board/view";
	}
	@GetMapping("update/{num}")
	public String update(@PathVariable int num, Model model) {
		BoardDTO board = bservice.findByNum(num);
		model.addAttribute("board", board);
		return "board/update";
	}
	@PostMapping("update")
	public String update(BoardDTO board) {
		bservice.update(board);
		return "redirect:list";
	}
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		bservice.delete(num);
		return "success";
	}
	
	
}
