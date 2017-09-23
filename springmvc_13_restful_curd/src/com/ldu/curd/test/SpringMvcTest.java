package com.ldu.curd.test;

import java.util.Collection;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldu.curd.dao.EmployeeDao;
import com.ldu.curd.entities.Employee;

@Controller
public class SpringMvcTest {
	@Resource
	private EmployeeDao employeeDao;
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	
	/**
	 * 连接实现国际化
	 */
	@Resource
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("/i18n")
	public String testI18n(Locale locale){
		String val = messageSource.getMessage("i18n.user", null, locale);
		System.out.println(val+"---"); 
		return "i18n1";
	}
	
	/*@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("/i18n")
	public String testI18n(Locale locale){
		String val = messageSource.getMessage("i18n.user", null, locale);
		System.out.println(val+"---"); 
		return "i18n1";
	}*/
}
