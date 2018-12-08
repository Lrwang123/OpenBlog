package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private ServletContext sc = null;
	private UserService userService = null;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url = req.getRequestURI();
		//System.out.println(url);
		String urlContext = url.substring(url.lastIndexOf('/'));
		if ("/login".equals(urlContext)){
			userService.login(req, resp);
		} else if ("/register".equals(urlContext)){
			userService.register(req, resp);
		} else if ("/ajaxVerify".equals(urlContext)){
			userService.ajaxVerify(req, resp);
		} else if ("/exit".equals(urlContext)){
			userService.exit(req, resp);
		}
		
		
		PrintWriter output = resp.getWriter();
		output.print("UserServlet:请求解析失败"+url);	
		output.flush();
		output.close();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		sc = this.getServletContext();
		userService = new UserServiceImpl(sc);
		log("UserServlet初始化完成");
	}

}
