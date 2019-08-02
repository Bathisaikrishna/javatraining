package com.visa.prj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {

	public static String generateCreateSQL(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		
		Table t = clazz.getAnnotation(Table.class);
		if(t != null) {
			builder.append("create table");
			builder.append(" ");
			builder.append(t.name());
			builder.append("(");
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if(method.getName().startsWith("get")) {
				Column c = method.getAnnotation(Column.class);
				if(c!=null) {
					builder.append(c.name());
					builder.append(" ");
					builder.append(c.type());
					builder.append(", ");
				}
				
				
			}
		}
		
		builder.setCharAt(builder.lastIndexOf(","), ')');
		return builder.toString();
		
	}
	
	//insert into products(prd_id,prd_name) values(120,'iPhone XR');
	public static String generateInsertSQL(Object obj)
	{
		StringBuilder builder = new StringBuilder();
		StringBuilder values = new StringBuilder();
		values.append(" values(");
		builder.append("insert into ");
		Table t = obj.getClass().getAnnotation(Table.class);
		builder.append(t.name() + "(");
		Method[] methods = obj.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if(method.getName().startsWith("get")) {
				Column c= method.getAnnotation(Column.class);
				if(c != null)
				{
					builder.append(c.name() + ",");
					try {
						if(c.type().startsWith("VARCHAR"))
						{
							values.append("'" + method.invoke(obj) + "'" + ",");
						}
						else if(c.type().startsWith("NUMERIC"))
						{
							values.append(method.invoke(obj) + ",");
						}
						
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), ')');
		
		values.setCharAt(values.lastIndexOf(","), ')');
		
		
		return builder.toString() + values.toString();
	}
}
