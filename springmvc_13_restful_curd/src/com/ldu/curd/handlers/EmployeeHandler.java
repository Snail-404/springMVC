package com.ldu.curd.handlers;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ldu.curd.dao.DepartmentDao;
import com.ldu.curd.dao.EmployeeDao;
import com.ldu.curd.entities.Department;
import com.ldu.curd.entities.Employee;

@Controller
public class EmployeeHandler {
	@Resource
	private EmployeeDao employeeDao;
	@Resource
	private DepartmentDao departmentDao;
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false,defaultValue="0") int id,Map<String, Object> map){
		if(id != 0){
			map.put("employee", employeeDao.get(id));
		}
	}
	

	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable int id,Map<String, Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable int id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(Employee employee,BindingResult result){
		System.out.println(employee);
		System.out.println(employee.getGender());
		
		if (result.getErrorCount()>0) {
			System.out.println("出错了");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
		}
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> map){
		System.out.println("list-------");
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
}
