package com.openlab.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public final class MybatisTools {

	@Autowired
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession openSession(){
		return sqlSessionFactory.openSession(true);
	}
	
}
