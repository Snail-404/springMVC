package com.ldu.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println("this is interceptor controller!");
		return "index.jsp";
	}
}
