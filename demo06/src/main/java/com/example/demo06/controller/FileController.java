package com.example.demo06.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo06.model.FileBoard;
import com.example.demo06.service.FileService;

@Controller
@RequestMapping("/file/*")
public class FileController {
	@Autowired
	private FileService fileService;
	
@GetMapping("insert")
public String insert() {
	return"/file/fileboardinsert";
}

@PostMapping("fileInsert")
public String insert(FileBoard fboard, HttpSession session) {
	String uploadFolder=session.getServletContext().getRealPath("/")+"\\resources\\img";
	fileService.fileInsert(fboard,uploadFolder);
return "return:list";
}
@GetMapping("list")
public String list(Model model) {
	model.addAttribute("lists", fileService.list());
	return "/file/filelist";
}

}
