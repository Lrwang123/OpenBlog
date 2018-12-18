package com.openlab.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.openlab.domain.UserBean;
import com.openlab.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired(required=true)
	@Qualifier("userServiceImpl")
	private UserService service;

	public UserController() {
		super();
		System.out.println("UserController初始化");
	}
	
	@RequestMapping("/login")
	public ModelAndView login(String action, String username, String password, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if ("login".equals(action)){
			Object res = service.login(username, password);
			if (res instanceof UserBean) {
				UserBean user = (UserBean)res;
				session.setAttribute("user", user);
				mv.setViewName("redirect:../blog/main");
				return mv;
			} else {
				mv.setViewName("user_login");
				mv.addObject("status", res);
				mv.addObject("username", username);
				return mv;
			}
		} else {
			mv.setViewName("user_login");
			return mv;
		}
	}
	
	@RequestMapping("/register")
	public ModelAndView register(UserBean user, String action) {
		if ("register".equals(action)) {
			boolean res = service.register(user);
			return new ModelAndView(res ? "user_register_success" : "user_register_fail");
		} else {
			return new ModelAndView("user_register");
		}
	}
	
	@RequestMapping("/exit")
	public ModelAndView exit(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("user");
		mv.setViewName("redirect:login");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/loginAjaxVerify")
	public String loginAjaxVerify(String str){
		String res = service.loginAjaxVerify(str);
		return res;
	}
	
	@RequestMapping("/registerAjaxVerify")
	public ModelAndView registerAjaxVerify(String type, String str){
		boolean valid = service.registerAjaxVerify(type,str);
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		mv.addObject("valid", valid);
		mv.addObject("message", valid ? "可用" : "不可用");
		return mv;
		
	}
}
