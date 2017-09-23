package com.ldu.ajax.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {
	@RequestMapping("/ajax")
	public void testAjax(String userName,HttpServletResponse resp) throws IOException{
		System.out.println("-------------------:"+userName);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		if (userName.equals("zs")) {
			System.out.println("777777777777777777");
			resp.getWriter().print("相同");
		}else{
			resp.getWriter().print("不相同");
		}
	}
}
