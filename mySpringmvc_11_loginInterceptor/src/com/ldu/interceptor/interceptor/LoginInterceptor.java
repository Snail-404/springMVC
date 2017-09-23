package com.ldu.interceptor.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ldu.interceptor.po.UserInfo;

public class LoginInterceptor implements HandlerInterceptor {
	private List<String> allowPass;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		String url = request.getRequestURI().toString();
		// 判断session中是否有
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
		if (user != null){
			System.out.println(user.getUserName());
			return true;
		}
		for (String itrm : allowPass) {
			if (url.endsWith(itrm))
				return true;
		}

		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return false;
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public List<String> getAllowPass() {
		return allowPass;
	}

	public void setAllowPass(List<String> allowPass) {
		this.allowPass = allowPass;
	}

}
