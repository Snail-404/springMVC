package com.ldu.interceptor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldu.interceptor.po.UserInfo;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(UserInfo user,HttpSession session){
		if ("admin".equals(user.getUserName())&&"123".equals(user.getPassWord())) {
			session.setAttribute("user", user);
			System.out.println("login success");
			return "redirect:/index.jsp";
		}else
			System.out.println("login fail");
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println("hello");
		return "redirect:/hello.jsp";
	}
}
