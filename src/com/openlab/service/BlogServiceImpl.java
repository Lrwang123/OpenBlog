package com.openlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.openlab.dao.BlogDao;
import com.openlab.domain.BlogBean;
import com.openlab.domain.MessageBean;
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

	@Override
	public BlogBean getBlogByBlogId(Integer blogId) {
		return blogDao.getBlogByBlogId(blogId);
	}

	@Override
	public void addBlog(BlogBean blog, int userId) {
		if ("".equals(blog.getTitle()))
			throw new RuntimeException("发布blog信息不能为空");
		blogDao.addBlog(blog, userId);
	}

	@Override
	public void editBlog(BlogBean blog, int userId) {
		if (blog.getId()==0 || blog.getTitle()==null || blog.getInfo()==null || blog.getType()==null || blog.getBlog_text()==null){
			throw new RuntimeException("修改博客内容不能为空");
		}else if (blogDao.UpdateBlog(blog, userId) <= 0){
			throw new RuntimeException("修改博客内容失败");
		}
	}

	@Override
	public void deleteBlog(int blog_id, int user_id) {
		if (blogDao.delete(blog_id, user_id) <= 0) {
			throw new RuntimeException("删除博客失败");
		}
	}

	@Override
	public void addMessage(MessageBean message) {
		if (message.getBlogId() <= 0 || message.getText()==null){
			throw new RuntimeException("留言失败:留言不能为空");
		} else {
			blogDao.addMessage(message);
		}
	}

	@Override
	public void deleteMessage(Integer messageId, int id) {
		if (messageId != null) {
			blogDao.deleteMessage(messageId, id);
		} else {
			throw new RuntimeException("删除留言失败:留言编号不能为空");
		}
	}
	
}
