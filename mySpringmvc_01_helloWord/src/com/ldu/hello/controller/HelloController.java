package com.ldu.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("this is controller");
		ModelAndView mov=new ModelAndView();
		mov.setViewName("hello");
		mov.addObject("msg", "hello spring mvc");
		return mov;


		
	}

}
