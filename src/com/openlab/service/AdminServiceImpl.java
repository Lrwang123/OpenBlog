package com.openlab.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

	public AdminServiceImpl() {
		super();
		System.out.println("AdminServiceImpl初始化");
	}

	@Override
	public boolean login(HttpServletRequest req) {
		System.out.println("login方法");
		return false;
	}
	
}
