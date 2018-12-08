package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import domain.UserBean;

public interface AdminMapper {
	
	public int loginVerify(@Param("username") String username,@Param("password") String password);
	
	public List<UserBean> getUserList();
	
	public int ban(int id);
	
	public int unban(int id);
	
}
