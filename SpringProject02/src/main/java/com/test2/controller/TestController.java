package com.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // handleRequestInternal�� ��ӹ��� �ʾƵ� �Ǵ� ������̼�
public class TestController {
	@RequestMapping("test.go")
	public String test() { // string�� view�� ����Ų��
		System.out.println("test");
		return "result"; // result.jsp�� ����Ű�� ��, = "WEB-INF/jsp/result.jsp"
	}
	@RequestMapping("test22.go")
	public void test22() { // void�� view�� ����Ų��
			
	}

}
