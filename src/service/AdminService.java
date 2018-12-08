package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AdminService {

	void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException;

	void ban (HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException;
	
	void unban (HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException;

	void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException;
	
}
