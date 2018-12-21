package com.openlab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.UserBean;
import com.openlab.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired(required=true)
	@Qualifier("adminServiceImpl")
	private AdminService adminService;
	
	public AdminController() {
		super();
		System.out.println("AdminController初始化");
	}

	@RequestMapping("/login")
	public ModelAndView login(String action, String username, String password, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		if ("login".equals(action)){
			int res = adminService.login(username, password);
			if (res > 0){
				session.setAttribute("admin", "admin");
				mv.setViewName("redirect:main");
				return mv;
			} else {
				mv.setViewName("admin_login");
				mv.addObject("status", "密码错误");
				mv.addObject("username", username);
				return mv;
			}
		} else {
			mv.setViewName("admin_login");
			return mv;
		}
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("admin_main");
		List<UserBean> userList = adminService.getUserList();
		mv.addObject("userList", userList);
		return mv;
	}
	
	@RequestMapping("/ban")
	public ModelAndView ban(Integer id) {
		adminService.ban(id);
		return new ModelAndView("redirect:main");
	}
	
	@RequestMapping("/unban")
	public ModelAndView unban(Integer id) {
		adminService.unban(id);
		return new ModelAndView("redirect:main");
	}
}
