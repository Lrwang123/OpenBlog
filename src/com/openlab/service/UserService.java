package com.openlab.service;

import com.openlab.domain.UserBean;

public interface UserService {

	public boolean register(UserBean user);

	public boolean registerAjaxVerify(String type, String str);

	public Object login(String username, String password);

	public String loginAjaxVerify(String str);

}
