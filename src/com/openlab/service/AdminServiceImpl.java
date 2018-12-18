package com.openlab.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.openlab.dao.AdminDao;
import com.openlab.domain.UserBean;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
	
	@Autowired(required=true)
	@Qualifier("adminDao")
	private AdminDao adminDao = null;
	
	public AdminServiceImpl() {
		super();
		System.out.println("AdminServiceImpl初始化");
	}
	
	@Override
	public List<UserBean> getUserList() {
		return adminDao.getUserList();
	}

	@Override
	public void ban(String id) {
		adminDao.ban(Integer.parseInt(id));
	}

	@Override
	public void unban(String id) {
		adminDao.unban(Integer.parseInt(id));
	}

	@Override
	public int login(String username, String password) {
		if (username != null && password != null)
			return adminDao.loginVerify(username, password);
		else 
			return -1;
	}

	
	
}
