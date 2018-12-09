package com.openlab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("adminServiceImpl")
	private AdminService adminService;
	
	public AdminController() {
		super();
		System.out.println("AdminController初始化");
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req) {
		String action = req.getParameter("action");
		if ("login".equals(action)){
			boolean res = adminService.login(req);
			if (res){
				return new ModelAndView("redirect:main");
			} else {
				ModelAndView mv = new ModelAndView("admin_login");
				mv.addObject("status", "密码错误");
				mv.addObject("username", req.getParameter("username"));
				return mv;
			}
		} else {
			return new ModelAndView("admin_login");
		}
	}
	
	@RequestMapping("/main")
	public void main() {
		
	}
	
	@RequestMapping("/ban")
	public void ban() {
		
	}
	
	@RequestMapping("/unban")
	public void unban() {
		
	}
}
