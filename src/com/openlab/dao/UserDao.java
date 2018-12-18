package com.openlab.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.openlab.domain.UserBean;

@Repository("userDao")
public interface UserDao {

	public UserBean login(String username, String password);
	
	public int register(UserBean user);
	
	public int isExist(@Param("type") String type, @Param("str") String str);

}
