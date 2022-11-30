package com.myspring.app05;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.model.GuestDTO;
import com.myspring.model.GuestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private GuestService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		
		return "insert";
	}
	
	// insert
	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("gInsert")
	public String insert(@ModelAttribute GuestDTO guest, HttpServletRequest request) {
		guest.setIpaddr(request.getRemoteAddr());
		service.guestInsert(guest);
	return "redirect:gList";
	}
	
	@GetMapping("gList")
	public String list(String field, String word, Model model) {
		service.guestList(null);
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word",word);
		List<GuestDTO> guests = service.guestList(hm);
		int count = service.guestCount(hm);
		model.addAttribute("guests", guests);
		model.addAttribute("count", count);
		return "list";
	}
}
