package com.openlab.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openlab.domain.UserBean;

public interface AdminService {

	public List<UserBean> getUserList();

	public void ban(Integer id);

	public void unban(Integer id);

	public int login(String username, String password);

}
