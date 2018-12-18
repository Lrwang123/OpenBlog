package com.openlab.utils;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public final class MybatisTools {

	@Autowired
	@Qualifier("sqlSessionFactory")
	private static SqlSessionFactoryBean sqlSessionFactory;
	
	public static SqlSession openSession(){
		try {
			return sqlSessionFactory.getObject().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
