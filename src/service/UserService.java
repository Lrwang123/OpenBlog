package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	public void ajaxVerify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
