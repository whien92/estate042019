package com.vvhien.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object = null;
		try {
			object = tClass.newInstance(); 
			BeanUtils.populate(object, request.getParameterMap());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return object;
	}
}
