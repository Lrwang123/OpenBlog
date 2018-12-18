package com.openlab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.openlab.domain.UserBean;

@Repository("adminDao")
public interface AdminDao {
	
	public int loginVerify(@Param("username") String username,@Param("password") String password);
	
	public List<UserBean> getUserList();
	
	public int ban(int id);
	
	public int unban(int id);
	
}
