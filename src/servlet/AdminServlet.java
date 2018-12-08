package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.AdminServiceImpl;

public class AdminServlet extends HttpServlet{
	private ServletContext sc = null;
	private AdminService adminService = null;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = req.getRequestURI();
		//System.out.println(url);
		String urlContext = url.substring(url.lastIndexOf('/'));
		if ("/login".equals(urlContext)){
			adminService.login(req, resp);
		} else if ("/main".equals(urlContext)){
			adminService.main(req, resp);
		} else if ("/ban".equals(urlContext)) {
			adminService.ban(req, resp);
		} else if ("/unban".equals(urlContext)){
			adminService.unban(req, resp);
		}
		
		
		PrintWriter output = resp.getWriter();
		output.print("AdminServlet:请求解析失败"+url);	
		output.flush();
		output.close();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		sc = this.getServletContext();
		adminService = new AdminServiceImpl(sc);
		log("AdminServlet初始化完成");
	}
}
