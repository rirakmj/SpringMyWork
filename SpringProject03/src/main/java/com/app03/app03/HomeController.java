package com.app03.app03;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app03.model.MPersonDAOImpl;
import com.app03.model.PersonDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MPersonDAOImpl dao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	// 추가form
//	@RequestMapping("insert")
		@GetMapping("insert")
		public String person_insert() {
			return "personForm";
		}
		
		// 추가
		@PostMapping("insert")
		public String insert(PersonDTO person) { // id이름과 객체 이름이 같다면 일일히 선언 안 해줘도 값이 들어감
			dao.person_insert(person);
			return "redirect:list";
		}
		
		// 전체 보기
		@RequestMapping("list")
		public String list(Model model) {
			List<PersonDTO> arr = dao.person_list();
			int count = dao.person_count();
			model.addAttribute("count", count);
			model.addAttribute("personlist",arr);
			return "personList";
			}

		// 상세 보기
//		@RequestMapping("view")
//		public String view(String id, Model model) {
//			PersonDTO person = dao.person_view(id);
//			model.addAttribute("person", person);
//			return "personView";
//		}
//		
//		
//		// 수정form
//		@GetMapping("update")
//		public String update(String id, Model model) {
//			model.addAttribute("person", dao.person_view(id));
//			return "personUpdate";
//		}
		
		// 상세 보기 & 수정폼
		@RequestMapping({"view","update"})
		public void view(String id, Model model) {
			PersonDTO person = dao.person_view(id);
			model.addAttribute("person", person);
		}
		
		// 수정
		@PostMapping("update")
		public String update(PersonDTO person) {
			dao.person_update(person);
			return "redirect:list";
		}
		
		// 삭제
		@RequestMapping("delete")
		public String delete(String id) {
			dao.person_delete(id);
			return "redirect:list";
		}
	}
		
