package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.openlab.utils.MybatisTools;

import dao.AdminMapper;
import domain.UserBean;

public class AdminServiceImpl implements AdminService {

	private ServletContext sc;
	
	public AdminServiceImpl(ServletContext sc) {
		this.sc = sc;
	}
	
	//登陆业务，成功会session增加admin属性
	@Override
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String action = req.getParameter("action");
		if ("login".equals(action)){
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			SqlSession ss = null;
			try {
				ss = MybatisTools.openSession();
				AdminMapper mapper = ss.getMapper(AdminMapper.class);
				int res = mapper.loginVerify(username, password);
				if (res > 0) {
					req.getSession().setAttribute("admin","true");
					resp.sendRedirect("main");
				} else {
					req.setAttribute("status", "fail");
					req.getRequestDispatcher("../jsp/admin_login.jsp").forward(req, resp);				
				}
			} finally {
				ss.close();
			}
		} else {
			req.getRequestDispatcher("../jsp/admin_login.jsp").forward(req, resp);
		}
	}
	
	//用户管理业务
	@Override
	public void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSession ss = MybatisTools.openSession();
		AdminMapper mapper = ss.getMapper(AdminMapper.class);
		List<UserBean> userList = mapper.getUserList();
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("../jsp/admin_main.jsp").forward(req, resp);
	
	}

	@Override
	public void ban(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SqlSession ss = null;
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			ss = MybatisTools.openSession();
			AdminMapper mapper = ss.getMapper(AdminMapper.class);
			mapper.ban(id);
			resp.sendRedirect("main");
		} finally {
			ss.close();
		}
		
		
	}

	@Override
	public void unban(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SqlSession ss = null;
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			ss = MybatisTools.openSession();
			AdminMapper mapper = ss.getMapper(AdminMapper.class);
			mapper.unban(id);
			resp.sendRedirect("main");
		} finally {
			ss.close();
		}
	}

	
	
}
