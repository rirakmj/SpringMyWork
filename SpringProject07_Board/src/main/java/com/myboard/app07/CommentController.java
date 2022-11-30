package com.myboard.app07;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.dto.MemberDTO;
import com.myboard.model.CommentService;

@RequestMapping("/reply/*") // reply 타고 오는 모든 항목 적용
@RestController // @Controller + @ResponseBody
public class CommentController {
	
	@Autowired
	private CommentService cservice;
	
	// 댓글 추가
	@PostMapping("commentInsert")
	// @ResponseBody
	public String insert(@RequestBody CommentDTO comment, HttpSession session) {
		String id = ((MemberDTO)session.getAttribute("sMember")).getId();
		comment.setUserid(id); // session.getId는 session이 만드는 id를 뜻함
		cservice.insert(comment);
		return "success";
	}

	// 댓글 전체보기
	// @GetMapping("commentList")
	// @ResponseBody
	// public List<CommentDTO> getList(int bnum) {
		// return cservice.getList(bnum);
		
	@GetMapping("commentList/{bnum}")
	public List<CommentDTO> getList(@PathVariable int bnum) {
		return cservice.getList(bnum);
	}
	
	// 댓글 삭제
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}

	
}