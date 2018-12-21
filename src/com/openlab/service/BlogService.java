package com.openlab.service;

import java.util.List;

import com.openlab.domain.BlogBean;
import com.openlab.domain.MessageBean;
import com.openlab.domain.UserBean;


public interface BlogService {

	public List<BlogBean> getAllBlog();

	public UserBean getUserByUserId(Integer userId);

	public List<BlogBean> getAllBlogByUserId(Integer userId);

	public BlogBean getBlogByBlogId(Integer blogId);

	public void addBlog(BlogBean blog, int userId);

	public void editBlog(BlogBean blog, int userId);

	public void deleteBlog(int blog_id, int user_id);

	public void addMessage(MessageBean message);

	public void deleteMessage(Integer messageId, int id);
	
}
