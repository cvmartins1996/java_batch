package com.customer.io.configuration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassName {
	private Field[] declaredFields;
	private List<String> fields = new ArrayList<>();
	
	public List<String> to(Class<?> className, Long Id) {
		try {
			
			className.newInstance();
			className.getConstructor();
			declaredFields = className.getDeclaredFields();
			
			for (Field field : declaredFields) {
				System.out.println("field  " + field.getName());
				fields.add(field.getName());
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return fields;
	}
	
}

