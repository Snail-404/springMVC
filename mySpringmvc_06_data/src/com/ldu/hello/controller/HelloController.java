package com.ldu.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ldu.hello.po.UserInfo;

@Controller
public class HelloController {
	@RequestMapping(value="/hello",method=RequestMethod.POST,params={"userName","password!=null"})
	public String hello(@RequestParam("userName")String name,String sex){
		System.out.println("this is name:"+name);
		System.out.println("this is sex:"+sex);
		return "index.jsp";
	}
	
	@RequestMapping("/userinfo")
	public String getUser(UserInfo user){
		System.out.println(user);
		return "usertest.jsp";
	}
	
	@RequestMapping("/user")
	public String showUser(UserInfo user,ModelMap modelMap){
		modelMap.addAttribute("userinfo", user);
		return "usertest.jsp";
	}
	
	@RequestMapping("/res")
	public void resreq(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String name=req.getParameter("userName");
		System.out.println("request name:"+name);
		req.setAttribute("name", name);
		req.getRequestDispatcher("usertest.jsp").forward(req, res);
	}
	
	@RequestMapping("/shitu")
	public ModelAndView shitu(HttpServletRequest req,HttpServletResponse res){
		String pwd=req.getParameter("passWord");
		ModelAndView mv=new ModelAndView();
		mv.addObject("pass", pwd);
		mv.setViewName("usertest.jsp");
		return mv;
		
	}
	
}
