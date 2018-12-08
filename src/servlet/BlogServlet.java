package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;
import service.BlogServiceImpl;

public class BlogServlet extends HttpServlet {
	
	private ServletContext sc;
	private BlogService blogService;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getRequestURI();
		try {	
			String urlContext = url.substring(url.lastIndexOf('/'));
			if ("/blog_article_list".equals(urlContext)){
				blogService.blog_article_list(req,resp);
			} else if ("/blog_main".equals(urlContext)) {
				blogService.blog_main(req, resp);
			} else if ("/blog_article".equals(urlContext)) {
				blogService.blog(req, resp);
			} else if ("/blog_add".equals(urlContext)){
				blogService.blog_add(req, resp);
			} else if ("/blog_edit".equals(urlContext)){
				blogService.blog_edit(req, resp);
			} else if ("/blog_delete".equals(urlContext)){
				blogService.blog_delete(req, resp);
			} else if ("/addMessage".equals(urlContext)) {
				blogService.addMessage(req, resp);
			} else if ("/deleteMessage".equals(urlContext)) {
				blogService.deleteMessage(req, resp);
			}
		} catch (Exception e) {
			PrintWriter output = resp.getWriter();
			output.print("BlogServlet:服务器异常"+url);	
			output.flush();
			output.close();
			e.printStackTrace();
		}
		PrintWriter output = resp.getWriter();
		output.print("BlogServlet:请求解析失败"+url);	
		output.flush();
		output.close();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sc = this.getServletContext();
		blogService = new BlogServiceImpl(sc);
		log("BlogServlet初始化完成");
	}
	
}
