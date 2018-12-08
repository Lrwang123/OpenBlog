package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.openlab.utils.MybatisTools;
import com.openlab.utils.VerifyTools;

import dao.UserMapper;
import domain.BlogBean;
import domain.UserBean;
import exception.FormatErrorException;

public class UserServiceImpl implements UserService {

	private UserMapper userDao;
	private SqlSession sqlSession;
	private ServletContext sc;
	public UserServiceImpl(){};
	public UserServiceImpl(ServletContext sc) {
		super();
		this.sc = sc;
		sqlSession = MybatisTools.openSession();
		userDao = sqlSession.getMapper(UserMapper.class);
	}
	
	//登陆业务
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		//已经登陆过，直接到个人主页
		if (session.getAttribute("user") != null){
			resp.sendRedirect("../blog/blog_main");
			return;
		} else if ("login".equals(req.getParameter("action"))){
			//登陆请求
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			sqlSession.clearCache();
			UserBean res = userDao.login(username, password);
			if (res != null) {
				//账号密码正确
				if (res.getStatus() != 0) {
					session.setAttribute("user", res);
					resp.sendRedirect("../blog/blog_main");
				} else {
					//账号被封
					req.setAttribute("status", "账号被封禁,请联系管理员!");
					req.setAttribute("username", username);
					req.getRequestDispatcher("../jsp/user_login.jsp").forward(req, resp);					
				}
			} else {
				//错误
				req.setAttribute("status", "密码错误");
				req.setAttribute("username", username);
				req.getRequestDispatcher("../jsp/user_login.jsp").forward(req, resp);
			}
		} else {
			//返回登陆页面
			req.getRequestDispatcher("../jsp/user_login.jsp").forward(req, resp);
		} 
	}
	
	//注册业务
	public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//判断请求，action为register进行注册业务，否则跳转注册页面
		if ("register".equals(req.getParameter("action"))) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String nickname = req.getParameter("nickname");
			String sign = req.getParameter("sign");
			String sex = req.getParameter("sex");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("province") + "." + req.getParameter("city") + "." + req.getParameter("district");
			UserBean user = new UserBean(username, password, nickname, sign, sex, email, phone, address);
			System.out.print(user);
			boolean res = userDao.register(user)>0;
			
			PrintWriter output = resp.getWriter();
			output.print(res ? "注册成功" : "注册失败");
			output.flush();
			output.close();
		
		} else {
			req.getRequestDispatcher("../jsp/user_register.jsp").forward(req, resp);
			return;
		}	
	}

	//异步验证业务
	public void ajaxVerify(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter output = null;
		String type = req.getParameter("type");	
		String str = req.getParameter("str");
		boolean valid = false;
		String message = "";
		
		try {
			output = resp.getWriter();
			if ("loginUsername".equals(type)){
				valid = userDao.isExist("username", str) > 0;
				System.out.println(type +"是否存在"+valid+str);
				return;
			}
			VerifyTools.formatVerify(type, str);
			valid = userDao.isExist(type, str) > 0;
			if (valid == false) {
				valid = true;
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FormatErrorException e) {
			valid = false;
			message = e.getMessage();
		} finally {
			output.print("{\"valid\":"+valid+", \"message\":\""+message+"\"}");
			output.flush();
			output.close();
		}
	}
	
	//退出登陆业务
	@Override
	public void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().removeAttribute("user");
		req.getSession().removeAttribute("blog_list");
		resp.sendRedirect("login");
	}

}
