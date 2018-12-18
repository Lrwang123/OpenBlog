package com.openlab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.BlogBean;
import com.openlab.domain.UserBean;
import com.openlab.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	@Qualifier("blogServiceImpl")
	private BlogService blogService;
	
	
	@RequestMapping("/blog_article_list")
	public ModelAndView blog_article_list(){
		List<BlogBean> blog_list = blogService.getAllBlog();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("blog_article_list");
		mv.addObject(blog_list);
		return mv;
	}
	
	@RequestMapping("/main")
	public ModelAndView blog_main(@SessionAttribute(value="user") UserBean user, Integer userId, HttpSession session){
		System.out.println(user);
		
		UserBean owner;
		UserBean user2 = (UserBean) session.getAttribute("user");
		if (userId == null) {
			owner = user2;
		} else {
			owner = blogService.getUserByUserId(userId);
		}
		List<BlogBean> list = blogService.getAllBlogByUserId(owner.getId());

		System.out.println(user.getId()+ "   " + user.getUsername());
		System.out.println(user2.getId() + "   " + user2.getUsername());

		ModelAndView mv = new ModelAndView("blog_main");
		mv.addObject("owner", owner);
		mv.addObject("blog_list", list);
		return mv;
	}
	
	@RequestMapping("/blog_article")
	public ModelAndView blog_article(){
		return null;
	}
	
	@RequestMapping("/blog_add")
	public ModelAndView blog_add(){
		return null;
	}
	
	@RequestMapping("/blog_edit")
	public ModelAndView blog_edit(){
		return null;
	}
	
	@RequestMapping("/blog_delete")
	public ModelAndView blog_delete(){
		return null;
	}
	
	@RequestMapping("/addMessage")
	public ModelAndView addMessage(){
		return null;
	}
	
	@RequestMapping("/deleteMessage")
	public ModelAndView deleteMessage(){
		return null;
	}
}
