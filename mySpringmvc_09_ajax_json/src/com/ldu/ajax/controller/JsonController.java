package com.ldu.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldu.ajax.po.UserInfo;

@Controller
public class JsonController {
	@ResponseBody
	@RequestMapping("/json")
	public List<UserInfo> testJson(){
		System.out.println("lksdfjjjjjjjjjjjjjjjjjjjjjjjjj");
		List<UserInfo> list =new ArrayList<UserInfo>();
		list.add(new UserInfo(1,"zs","12"));
		list.add(new UserInfo(2,"ls","13"));
		list.add(new UserInfo(3,"ww","14"));
		System.out.println(list);
		return list;
	}
}
