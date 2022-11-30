package com.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // handleRequestInternal을 상속받지 않아도 되는 어노테이션
public class TestController {
	@RequestMapping("test.go")
	public String test() { // string은 view를 가리킨다
		System.out.println("test");
		return "result"; // result.jsp를 가리키는 것, = "WEB-INF/jsp/result.jsp"
	}
	@RequestMapping("test22.go")
	public void test22() { // void도 view를 가리킨다
			
	}

}
