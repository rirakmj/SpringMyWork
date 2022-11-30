package com.myboard.app07;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.PageVO;
import com.myboard.model.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		return "boardInsert";
//	}
	@PostMapping("insert")
	public String insert(BoardDTO board, HttpServletRequest request) {
		service.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("insert")
	public String insert(HttpSession session) {
		if(session.getAttribute("sMember")==null) {
		return "member/login";
	}
		return "boardInsert";
	}
	
	@GetMapping({"/", "list"})
	public String list(Model model, String pageNum,
			@RequestParam(name="field", defaultValue="")String field, 
			@RequestParam(name="word", defaultValue="")String word) { // 처음 페이지 띄올 때는 filed, word가 없기 때문에 공백으로 설정함
		int currentPage = pageNum==null?1:Integer.parseInt(pageNum);
		int pageSize = 5;
		
	HashMap<String, Object> hm = new HashMap<String, Object>();
	hm.put("field", field);
	hm.put("word", word);
	hm.put("pageStart", (currentPage-1)*pageSize);
	hm.put("pageSize", pageSize);
	List<BoardDTO> barr = service.findAll(hm);
	int count = service.getCount(hm);
	PageVO page = new PageVO(count, currentPage, pageSize);
	page.setField(field);
	page.setWord(word);
	model.addAttribute("rowNo",count-(currentPage-1)*pageSize); // 실제 게시글 갯수로 번호 붙이기
	model.addAttribute("barr", barr);
	model.addAttribute("count", count);
	model.addAttribute("p", page);
	return "boardList";
	}
//	
//	@ResponseBody
//	public BoardListDTO list(@RequestParam(name="field") String field,
//			@RequestParam(name="word") String word) {	
//		HashMap<String, Object> hm = new HashMap<String, Object>();
//		hm.put("field",  field);
//		hm.put("word", word);
//		List<BoardDTO> barr = service.findAll(hm);
//		int count = service.getCount(hm);
//		BoardListDTO listdto = new BoardListDTO(barr, count);
//		return listdto;
//	}
	
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model, HttpSession session) {
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
		return "boardView";
        }
	
	@DeleteMapping("delete/{num}") // js 추가하면 getmapping에서 deletemapping으로 바꿔줘야
	@ResponseBody
	public String delete(@PathVariable int num) {
		service.delete(num);
		return "success"; // 주소 앞에 / 있는 것은 절대 경로
	}
	
	// 수정폼
	@GetMapping("update/{num}")
	public String update(@PathVariable int num, Model model) {
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
		return "boardUpdate";
	}

	// 수정
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardDTO board) {
		service.update(board);
		return "success"; // callback
	}
}
