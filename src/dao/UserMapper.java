package dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import domain.BlogBean;
import domain.UserBean;

public interface UserMapper {

	public UserBean login(String username, String password);
	
	public int register(UserBean user);
	
	public int isExist(@Param("type") String type, @Param("str") String str);

}
