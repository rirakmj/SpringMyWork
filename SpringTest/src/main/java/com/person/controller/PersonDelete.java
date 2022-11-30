package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;

public class PersonDelete extends AbstractController {
	private PersonDAOImpl dao;
	
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String id = req.getParameter("id");
		dao.personDelete(id); // ��ü�� ���ԵǾ� ����
		return new ModelAndView("redirect:personList.sp");
	}

}
