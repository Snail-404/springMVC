package com.ldu.curd.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor {

	/**
	 * 目标方法执行前执行
	 * 若返回true则继续执行目标方法和下面的拦截器
	 * 若返回false则停止，，目标方法和下面的拦截器 不在执行
	 */
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("preHandle");
		return true;
	}
	
	/**
	 * 目标方法执行时执行，但在试图渲染之前执行
	 * 可以用来修改请求属性和修改视图渲染
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle");
		
	}

	/**
	 * 目标方法执行完之后执行
	 * 可以用来释放资源
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");
	}

}
