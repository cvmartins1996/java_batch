package com.customer.io.configuration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.customer.io.core.CustomerDto;

public class ClassName {
	private Field[] declaredFields;
	private List<String> fields = new ArrayList<>();
	
	public List<String> to(Class<?> className, Long Id) {
		try {
			
			newInstance(className);
			constructor(className);
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

	private void constructor(Class<?> className) throws NoSuchMethodException {
		className.getConstructor();
	}

	private void newInstance(Class<?> className) throws InstantiationException, IllegalAccessException {
		className.newInstance();
	}
	
	public static boolean set(Object object, String fieldName, Object fieldValue) {
		Class<?> className = object.getClass();
		
		try {
			Field declaredField = className.getDeclaredField(fieldName);
			
			declaredField.setAccessible(true);
			declaredField.set(object, fieldValue);
			
			return true;
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}


class Teste{
	public static void main(String[] args) {
		try {
			Class<?> className = Class.forName(CustomerDto.class.getName());
			Object instance = className.newInstance();
			ClassName.set(instance, "id", 12);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
