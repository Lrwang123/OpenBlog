package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BlogService {
	
	public void blog_article_list(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;

	public void blog_main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	public void blog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	public void blog_add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	public void blog_edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	public void blog_delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	public void addMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	public void deleteMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
