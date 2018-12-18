package com.openlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.openlab.dao.UserDao;
import com.openlab.domain.UserBean;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao = null;
	
	public UserServiceImpl() {
		super();
		System.out.println("UserServiceImpl初始化");
	}

	@Override
	public String loginAjaxVerify(String username) {
		String res = "";
		if (username != null) {
			boolean isExist = userDao.isExist("username", username) > 0;
			res = isExist ? "exist" : "notExist";
		}
		return res;
	}

	@Override
	public boolean registerAjaxVerify(String type, String str) {
		boolean valid = userDao.isExist(type, str) == 0;
		return valid;
	}
	
	/**
	 * @return 返回登陆成功的对象或者错误信息
	 */
	@Override
	public Object login(String username, String password) {
		if (username != null && password != null) {
			UserBean user = userDao.login(username, password);
			if (user == null) {
				return "密码错误";
			} else if (user.getStatus() == 0) {
				return "账号被封，请联系管理员";
			} else {
				return user;
			}
		} else {			
			return "账号密码不能为空";
		}
	}

	@Override
	public boolean register(UserBean user) {
		if (user.getUsername() != null
				&user.getPassword() != null
				&user.getNickname() != null
				&user.getSex() != null
				&user.getEmail() != null
				&user.getPhone() != null
				&user.getAddress() !=null
				&user.getSign() != null) {
			boolean res = userDao.register(user)>0;
			return res;			
		} else {
			return false;
		}
	}
	
}
