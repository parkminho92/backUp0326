package com.kh.common;

public class StringUtils {
	
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isEmpty(String s) {
		if(s == null || "".equals(s)) {
			return true;
		}
		return false;
	}
	
	public static String getValue(String s) {
		if(isEmpty(s)) {
			return "";
		}
		return s;
	}
}
