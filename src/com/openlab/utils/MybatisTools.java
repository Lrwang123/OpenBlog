package com.openlab.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class MybatisTools {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "conf.xml";
		try {
			InputStream input = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		} catch (IOException e) {
			System.out.println("SqlSessionFactory加载失败");
			e.printStackTrace();
		}
	}
	
	public static SqlSession openSession(){
		return sqlSessionFactory.openSession(true);
	}
	
}
