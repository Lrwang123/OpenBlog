package com.openlab.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public final class ReflectTools {
	
	public static <E extends Object> E CreateBean(ResultSet rs, E e) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			String colName = rsmd.getColumnName(i);
			Field[] fields = e.getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				if (colName.toLowerCase().equals(fields[j].getName())){
					
				}
			}
		}
		
		
		
		return null;
	}
	
}
