package com.openlab.service;

import java.util.List;

import com.openlab.domain.BlogBean;
import com.openlab.domain.UserBean;


public interface BlogService {

	public List<BlogBean> getAllBlog();

	public UserBean getUserByUserId(Integer userId);

	public List<BlogBean> getAllBlogByUserId(Integer userId);
	
}
