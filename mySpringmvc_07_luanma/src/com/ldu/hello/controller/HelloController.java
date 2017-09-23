package com.ldu.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ldu.hello.po.UserInfo;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(String name,ModelMap model){
		System.out.println("this is name:"+name);
		model.addAttribute("name", name);
		return "index.jsp";
	}
	
	
	@RequestMapping("/user")
	public String showUser(UserInfo user,ModelMap modelMap){
		modelMap.addAttribute("userinfo", user);
		System.out.println(user.getUserName());
		return "usertest.jsp";
	}
	
	@RequestMapping("/{id}/{uid}/restful")
	public String byRestful(@PathVariable String id,@PathVariable String uid,ModelMap model){
		System.out.println(id);
		System.out.println(uid);
		model.addAttribute("id", id);
		model.addAttribute("uid", uid);
		return "/index.jsp";
	}
	
}
