package com.myboard.app007;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@RequestMapping("/reply/*")
@RestController //@Controller +@ResponseBody
public class CommentController {
	@Autowired
	private CommentService cservice;
    
	//��ۻ���
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return  cnum;
	}
	//����߰�
	@PostMapping("commentInsert")
	//@ResponseBody
	public String insert(@RequestBody CommentDTO comment, HttpSession session) {
		String id =((MemberDTO)session.getAttribute("sMember")).getId();
		comment.setUserid(id);
		cservice.insert(comment);
		return "success";
	}
	
	//�����ü����
	@GetMapping("commentList/{bnum}")
	public List<CommentDTO> getList(@PathVariable int bnum) {
		return  cservice.getList(bnum);
	}
	
//	@GetMapping("commentList")
//	//@ResponseBody
//	public List<CommentDTO> getList(int bnum) {
//		return  cservice.getList(bnum);
//	}
}
