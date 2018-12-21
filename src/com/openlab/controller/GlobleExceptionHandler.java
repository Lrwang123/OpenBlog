/**
 * 
 */
package com.openlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.openlab.exception.NotLoginException;

/**
 * <p>公司信息:OpenLab</p>
 * @author Lrwang
 *
 */
@Controller
@ControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(NotLoginException.class)
	public String notLoginException(Exception e){
		return "exception_notlogin";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String runtimeException(Exception e, Model model){
		model.addAttribute("message", e.getMessage());
		return "exception_runtime";
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e){
		e.printStackTrace();
		return "exception_other";
	}
}
