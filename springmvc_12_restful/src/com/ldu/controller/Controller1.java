package com.ldu.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ldu.pojo.People;
import com.ldu.pojo.User;


@Controller
@RequestMapping("/contro")
@SessionAttributes(value={"users","test"},types={String.class,Integer.class})
public class Controller1 {	
	
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
		map.put("time", new Date());
		map.put("list", Arrays.asList("zd",123,new Date()));
		return "success";
	}
	
	/**
	 * @SessionAttributes 可以通过map的key值向session加入指定的map
	 * 还可以通过map中value的类型@RequestMapping
	 * @SessionAttributes只能加载类上方不能修饰方法
	 * 
	 */
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String,Object> map){
		map.put("pass", "255464");
		User user=new User("zhanfgsan","23432jk");
		map.put("users", user);
		map.put("test", "klsdjfl");
		map.put("tt", 132);
		return "success";
	}
	
	@ModelAttribute
	public void getPeo(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map){
		
		if (id !=null) {
			People people=new People(1, "dkl", "123", 33);
			System.out.println("从数据库中获取对象："+people);
			map.put("people", people);
			//map.put("abc", people);
		}
		
	}
	/**
	 * 如果map中的key值与传入参数不一致则使用@RequestMapping("abc")
	 * @param people
	 * @return
	 */
	@RequestMapping("testModelAttribute")
	public String testModelAttribute(People people){
		System.out.println("修改:"+people);
		return "success";
	}
	
	/**
	 * 测试自定义师徒解析器
	 */
	@RequestMapping("testMyView")
	public String testMyView(){
		System.out.println("lksdjflkjlk");
		return "helloView";
	}
}
