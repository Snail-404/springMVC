package com.ldu.interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor implements HandlerInterceptor{

	/**
	 * 在Controller的处理方法之前被执行
	 * 执行一些初始化，权限判断，日志等处理
	 * 如果返回false 将不会执行Controller中的处理方法
	 * */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		System.out.println("------------处理之前-------------");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return false;
	}
	/**
	 * 在Controller处理方法执行之后，在被渲染之前 执行
	 * 关闭，释放，处理一些Controller执行中需要的资源
	 * */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("------------处理之后-------------");
		
	}
	
	/**
	 * 在渲染器渲染后被执行
	 * 处理一个请求后的一些清理
	 * */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
