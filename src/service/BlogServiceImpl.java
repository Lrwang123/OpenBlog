package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import com.openlab.utils.MybatisTools;

import dao.BlogMapper;
import domain.BlogBean;
import domain.MessageBean;
import domain.UserBean;

public class BlogServiceImpl implements BlogService {
	
	private ServletContext sc;
	private SqlSession sqlSession;
	private BlogMapper blogDao;
	
	public BlogServiceImpl(ServletContext sc) {
		this.sc = sc;
		sqlSession = MybatisTools.openSession();
		blogDao = sqlSession.getMapper(BlogMapper.class);
	}
	//随便逛逛，提供文章列表业务
	@Override 
	public void blog_article_list(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		//获取文章列表，传递给article_list.jsp
		ArrayList<BlogBean> blog_list = blogDao.getAllBlog();
		req.setAttribute("blog_list", blog_list);
		req.getRequestDispatcher("../jsp/blog_article_list.jsp").forward(req, resp);
	}

	//展示个人主页业务
	@Override 
	public void blog_main(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//按照user_id获取某人用户信息及博客页面，跳转至展示页面
		try {
			int userId = req.getParameter("userId")!=null? Integer.parseInt(req.getParameter("userId")) : ((UserBean)req.getSession().getAttribute("user")).getId();
			UserBean owner = blogDao.getUserByUserId(userId);
			if (owner != null) {				
				ArrayList<BlogBean> list = blogDao.getAllBlogByUserId(userId);
				req.setAttribute("owner", owner);
				req.setAttribute("blog_list", list);
				req.getRequestDispatcher("../jsp/blog_main.jsp").forward(req, resp);
			} else {
				throw new Exception();
			}
		}  catch (Exception e){
			PrintWriter output;
			output = resp.getWriter();
			output.print("这个人藏起来了，去看其他人的博客吧");	
			output.flush();
			output.close();
		}
				
		
	}

	//查看具体文章业务
	@Override 
	public void blog(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//按照文章编号获取文章内容，跳转至文章页面
		try {
			int blogId = Integer.parseInt(req.getParameter("blogId"));
			BlogBean blog = blogDao.getBlogByBlogId(blogId);
			if (blog != null) {				
				req.setAttribute("blog", blog);
				req.getRequestDispatcher("../jsp/blog_article.jsp").forward(req, resp);
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e){
			PrintWriter output = resp.getWriter();
			output.print("请求的文章不存在");	
			output.flush();
			output.close();
		}
	}

	//添加文章业务
	@Override 
	public void blog_add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String type = req.getParameter("type");
		String info = req.getParameter("info");
		String blog_text = req.getParameter("blog_text");
		if ("add".equals(req.getParameter("action")) && title!=null && type!=null && info!=null && blog_text!=null){
			//添加内容至数据库,返回个人主页
			BlogBean blog = new BlogBean();
			blog.setTitle(title);
			blog.setType(type);
			blog.setInfo(info);
			blog.setBlog_text(blog_text);
			blogDao.addBlog(blog, ((UserBean)req.getSession().getAttribute("user")).getId());
			sqlSession.clearCache();
			resp.sendRedirect("blog_main");
		} else {
			//返回发表页面
			req.getRequestDispatcher("../jsp/blog_add.jsp").forward(req, resp);
		}
	}

	//修改编辑文章业务
	@Override 
	public void blog_edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//无blog_id参数返回主页页面
		if (req.getParameter("blog_id") == null){
			try {
				resp.sendRedirect("blog_main");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//有blog_id，无文章参数，返回修改界面，有文章参数更新数据库
			String title = req.getParameter("title");
			String type = req.getParameter("type");
			String info = req.getParameter("info");
			String blog_text = req.getParameter("blog_text");
			if (title==null || type==null || info==null || blog_text==null){
				BlogBean old_blog = blogDao.getBlogByBlogId(Integer.parseInt(req.getParameter("blog_id")));
				req.setAttribute("old_blog", old_blog);
				req.getRequestDispatcher("../jsp/blog_edit.jsp").forward(req, resp);
				return;
			} else {
				BlogBean new_blog = new BlogBean();
				new_blog.setId(Integer.parseInt(req.getParameter("blog_id")));
				new_blog.setTitle(title);
				new_blog.setType(type);
				new_blog.setInfo(info);
				new_blog.setBlog_text(blog_text);
				int user_id = ((UserBean)req.getSession().getAttribute("user")).getId();
				blogDao.UpdateBlog(new_blog, user_id);
				sqlSession.clearCache();
				req.getRequestDispatcher("blog_main").forward(req, resp);
				return;
			}
		}
		
	}

	//删除文章业务
	@Override 
	public void blog_delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int blog_id = Integer.parseInt(req.getParameter("blog_id"));
		int user_id = ((UserBean)req.getSession().getAttribute("user")).getId();
		blogDao.delete(blog_id, user_id);
		sqlSession.clearCache();
		resp.sendRedirect("blog_main");
	}
	
	//添加评论业务
	@Override
	public void addMessage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//相应ajax请求，返回插入结果yes/no
		int res = 0;
		int blogId = -1;
		try {
			blogId = Integer.parseInt(req.getParameter("blogId"));
			int userId = ((UserBean)req.getSession().getAttribute("user")).getId();
			String text = req.getParameter("text");
			MessageBean message = new MessageBean();
			message.setBlogId(blogId);
			message.setUserId(userId);
			message.setText(text);
			res = blogDao.addMessage(message);
		} catch (PersistenceException e){
			System.out.println("addMessage出现异常,可能是用户非法输入引起");
		} 
		resp.sendRedirect("blog_article?blogId="+blogId);
	}
	
	//删除评论业务
	@Override
	public void deleteMessage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//相应ajax请求，删除某条评论
		int blogId = -1;
		try {
			blogId = Integer.parseInt(req.getParameter("blogId"));
			int messageId = Integer.parseInt(req.getParameter("messageId"));
			int userId = ((UserBean)req.getSession().getAttribute("user")).getId();
			blogDao.deleteMessage(messageId, userId);
		} catch (NumberFormatException | PersistenceException e) {
			System.out.println("deleteMessage出现异常,可能是用户非法输入引起");
		} 
		resp.sendRedirect("blog_article?blogId="+blogId);
	}
	
	

}
