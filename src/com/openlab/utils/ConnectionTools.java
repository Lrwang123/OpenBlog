package com.openlab.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class ConnectionTools {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	static {
		InputStream input = null;
		Properties prop = null;
		try {
			input = ConnectionTools.class.getResourceAsStream("dbinfo.properties");
			prop = new Properties();
			prop.load(input);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (prop != null)
				prop.clear();
		}
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败,正在重试");
			return getConnection();
		}
		return null;
	}
	
	public static void closeResource(Statement stat, ResultSet res){
		try {
			if (stat != null)
				stat.close();
			if (res != null)
				res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeResource(Statement stat){
		try {
			if (stat != null)
				stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeResource(ResultSet res){
		try {
			if (res != null)
				res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
