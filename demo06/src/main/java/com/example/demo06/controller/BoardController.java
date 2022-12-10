package com.example.demo06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo06.config.auth.PrincipalUser;
import com.example.demo06.model.Board;
import com.example.demo06.repository.BoardRepository;
import com.example.demo06.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board/*")
@Controller
@RequiredArgsConstructor
public class BoardController {
	@Autowired
	private BoardService boardService;
	private BoardRepository boardRepository;

	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String insert() {
		return "/board/insert";
	}

	@PostMapping("insert")
	public String insert(Board board, @AuthenticationPrincipal PrincipalUser principal) {
		boardService.insert(board, principal.getUser()); // user형태로 받아야 함
		return "redirect:/board/list";
	}

	// 게시글 전체보기
//	@GetMapping("list")
//	public String list(Model model) {
//		model.addAttribute("count", boardService.count());
//		model.addAttribute("boards", boardService.findAll());
//		return "/board/list";
//	}
	// 게시글 전체보기 페이징 (페이징 정보 + data-게시글 정보)
//	@GetMapping("list")
//	public String list(Model model,
//			@PageableDefault(size = 5, sort = "num", direction = Direction.DESC) Pageable pageable) {
//		Page<Board> lists = boardService.findAll(pageable);
//		model.addAttribute("count", boardService.count());
//		model.addAttribute("boards", lists);
//		return "/board/list";
//	}
	
	// 게시글 전체보기 페이징 + 검색
	@GetMapping("list")
	public String list(Model model,
			@PageableDefault(size = 5, sort = "num", direction = Direction.DESC) Pageable pageable,
			@RequestParam(required=false, defaultValue="") String field,
			@RequestParam(required = false, defaultValue = "") String word) {
		Page<Board> lists = boardService.findAll(field, word, pageable);
		Long count = boardService.count(field, word);
		model.addAttribute("boards", lists);
		model.addAttribute("count", count);
		return "/board/list";
	}

	@GetMapping("view/{num}")
	public String view(@PathVariable Long num, Model model) {
		model.addAttribute("board", boardService.findById(num));
		return "/board/view";
	}

	@GetMapping("update/{num}")
	public String update(@PathVariable Long num, Model model) {
		model.addAttribute("board", boardService.detail(num));
		return "/board/update";
	}
	
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Board board) {
		boardService.update(board);
		return "success";
	}

	@DeleteMapping("delete/{num}")
	@ResponseBody
	public Long delete(@PathVariable Long num) {
		boardService.delete(num);
		return num;
	}
}
