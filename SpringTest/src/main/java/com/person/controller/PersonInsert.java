package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.Person;
import com.person.model.PersonDAOImpl;

public class PersonInsert extends AbstractController{
	private PersonDAOImpl dao;
	//setter
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// to add the date on DB
		Person person = new Person();
		person.setGender(req.getParameter("gender"));
		person.setId(req.getParameter("id"));
		person.setJob(req.getParameter("job"));
		person.setName(req.getParameter("name"));
		person.setPassword(req.getParameter("password"));
		dao.personInsert(person);
//		return new ModelAndView("personList.sp"); // forward���
		return new ModelAndView("redirect:personList.sp");
	}

}
