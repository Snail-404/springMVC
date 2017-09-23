package com.ldu.curd.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandlerException {
	/**
	 * 在@ExceptionHandler 方法的入参中可以加入Exception类型的参数，该参数对应放生的异常对象
	 * @ExceptionHandler 方法入参中不能传入Map，若希望将异常信息显示在页面上，需要用modelandview
	 * @ExceptionHandler 方法异常有优先级，优先调用最贴近异常的异常
	 * @ControllerAdvice 若果在当前的handler中找不到@ExceptionHandler 处理当前的异常
	 * 		则去@ControllerAdvice 标记的类中查找@ExceptionHandler 标记的方法来处理当前的异常
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handlerArithmeticException(Exception ex){
		System.out.println("exception:"+ex);
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
}
