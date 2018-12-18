package com.openlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.openlab.dao.BlogDao;
import com.openlab.domain.BlogBean;
import com.openlab.domain.UserBean;

@Service("blogServiceImpl")
public class BlogServiceImpl implements BlogService {

	@Autowired
	@Qualifier("blogDao")
	private BlogDao blogDao;
	
	@Override
	public List<BlogBean> getAllBlog() {
		return blogDao.getAllBlog();
	}

	@Override
	public UserBean getUserByUserId(Integer userId) {
		return blogDao.getUserByUserId(userId);
	}

	@Override
	public List<BlogBean> getAllBlogByUserId(Integer userId) {
		return blogDao.getAllBlogByUserId(userId);
	}
	
}
