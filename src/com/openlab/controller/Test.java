package com.openlab.controller;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.openlab.dao.AdminDao;
import com.openlab.dao.BlogDao;
import com.openlab.domain.MessageBean;
import com.openlab.domain.UserBean;
import com.openlab.utils.MybatisTools;



public class Test {
	public static void main(String[] args) throws IOException {
		try (SqlSession ss = MybatisTools.openSession()){
			AdminDao mapper = ss.getMapper(AdminDao.class);
			int res = mapper.loginVerify("storm", "123456");
			System.out.println(res);
		}
	}	
}
