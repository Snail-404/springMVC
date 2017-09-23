package com.ldu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldu.pojo.User;

@Controller
public class RestfulController {
	@RequestMapping(value="/restful/{id}",method=RequestMethod.PUT)
	public String testPUT(@PathVariable int id){
		System.out.println("Test PUT:"+id);
		return "../index.jsp";
	}
	@RequestMapping(value="/restful/{id}",method=RequestMethod.DELETE)
	public String testDELETE(@PathVariable int id){
		System.out.println("Test DELETE:"+id);
		return "../index.jsp";
	}
	@RequestMapping(value="/restful",method=RequestMethod.POST)
	public String testPOST(){
		System.out.println("Test POST");
		return "index.jsp";
	}
	@RequestMapping(value="/restful/{id}",method=RequestMethod.GET)
	public String testGet(@PathVariable int id){
		System.out.println("Test GET:"+id);
		return "../index.jsp";
	}
	
	@RequestMapping("/testRest/{iddd}")
	public String restful(@PathVariable("iddd") int id,ModelMap model){
		model.addAttribute("id", id);
		System.out.println(id);
		return "../result.jsp";
	}
	
	/*
	 * @RequestParam 映射请求参数
	 * value 请求参数名
	 * required 参数是否为必须 默认ture
	 * defaultValue 默认值
	 */
	@RequestMapping("/requestParam")
	public String testRequestParam(@RequestParam(value="userName")String name,@RequestParam(required=false,defaultValue="0")int age){
		System.out.println("userName:"+name+"-----"+"age:"+age);
		return "index.jsp";
	}
	
	/*
	 * 了解
	 * 映射头文件信息
	 * 用法同@RequestParam
	 */
	@RequestMapping("/testrequestHeader")
	public String testrequestHeader(@RequestHeader(value="Accept-Encoding") String head){
		System.out.println(head);
		return "index.jsp";
	}
	
	/*
	 * 了解
	 * 映射一个cookie值
	 * 用法同@RequestParam
	 */
	@RequestMapping("/testCookie")
	public String testCookie(@CookieValue(value="JSESSIONID") String cookie){
		System.out.println(cookie);
		return "index.jsp";
	}
	
	/*
	 * 参数为pojo
	 * 支持级联
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user){
		System.out.println(user);
		return "index.jsp";
	}
	
}
