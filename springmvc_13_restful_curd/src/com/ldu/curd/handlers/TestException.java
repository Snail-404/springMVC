package com.ldu.curd.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestException {
	
	@RequestMapping("/testExceptionHandler")
	public String testExceptionHandler(int i){
		int result=10/i;
		System.out.println(result);
		return "success";
	}
}
