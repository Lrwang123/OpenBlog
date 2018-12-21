package com.openlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.BlogBean;
import com.openlab.domain.MessageBean;
import com.openlab.domain.UserBean;
import com.openlab.service.BlogService;

/**
 * <p>公司信息:OpenLab</p>
 * @author Lrwang
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	@Qualifier("blogServiceImpl")
	private BlogService blogService;
	
	
	
	public BlogController() {
		super();
		System.out.println("BlogController初始化");
	}

	@RequestMapping("/blog_article_list")
	public ModelAndView blog_article_list(){
		List<BlogBean> blog_list = blogService.getAllBlog();
		ModelAndView mv = new ModelAndView();
		mv.addObject("blog_list", blog_list);
		mv.setViewName("blog_article_list");
		mv.addObject(blog_list);
		return mv;
	}
	
	@RequestMapping("/blog_main")
	public ModelAndView blog_main(Integer userId, @SessionAttribute("user")UserBean user){
		UserBean owner;
		if (userId == null) {
			owner = user;
		} else {
			owner = blogService.getUserByUserId(userId);
		}
		List<BlogBean> list = blogService.getAllBlogByUserId(owner.getId());
		ModelAndView mv = new ModelAndView("blog_main");
		mv.addObject("owner", owner);
		mv.addObject("blog_list", list);
		return mv;
	}
	
	@RequestMapping("/blog_article")
	public ModelAndView blog_article(@RequestParam(value="blogId",required=false)Integer blogId){
		ModelAndView mv = new ModelAndView();
		if (blogId == null) {
			mv.setViewName("blog_article_fail");
		} else {
			BlogBean blog = blogService.getBlogByBlogId(blogId);
			if (blog == null) {
				mv.setViewName("blog_article_fail");
			} else {
				mv.setViewName("blog_article");
				mv.addObject("blog", blog);
			}
		}
		return mv;
	}
	
	@RequestMapping("/blog_add")
	public ModelAndView blog_add(String action, BlogBean blog, @SessionAttribute("user")UserBean user){
		ModelAndView mv = new ModelAndView();
		if ("add".equals(action)) {
			mv.setViewName("blog_add");
		} else {
			blogService.addBlog(blog, user.getId());
			mv.setViewName("redirect:blog_main");
		}
		return mv;
	}
	
	@RequestMapping("/blog_edit")
	public ModelAndView blog_edit(Integer blog_id, String action, BlogBean blog, @SessionAttribute("user")UserBean user){
		ModelAndView mv = new ModelAndView();
		if (action == null && blog_id != null) {
			//有id无action返回修改页面
			mv.setViewName("blog_edit");
			BlogBean old_blog = blogService.getBlogByBlogId(blog_id);
			mv.addObject("old_blog", old_blog);
		} else if ("edit".equals(action)){
			//有action进行修改操作
			blogService.editBlog(blog, user.getId());
			mv.setViewName("redirect:blog_main");
		} else {
			throw new RuntimeException("未知请求");
		}
		return mv;
	}
	
	@RequestMapping("/blog_delete")
	public ModelAndView blog_delete(Integer blog_id, @SessionAttribute("user")UserBean user){
		int user_id = user.getId();
		blogService.deleteBlog(blog_id, user_id);
		return new ModelAndView("redirect:blog_main");
	}
	
	@RequestMapping("/addMessage")
	public ModelAndView addMessage(MessageBean message, @SessionAttribute("user")UserBean user){
		int userId = user.getId();
		message.setUserId(userId);
		blogService.addMessage(message);
		return new ModelAndView("redirect:blog_article?blogId="+message.getBlogId());
	}
	
	@RequestMapping("/deleteMessage")
	public ModelAndView deleteMessage(Integer blogId, Integer messageId, @SessionAttribute("user")UserBean user){
		blogService.deleteMessage(messageId, user.getId());
		return new ModelAndView("redirect:blog_article?blogId=" + blogId);
	}
	
	@RequestMapping("/test")
	public void test(@SessionAttribute("user") UserBean user) throws Exception{
		if (user != null){
			throw new Exception();
		}
	}
}
