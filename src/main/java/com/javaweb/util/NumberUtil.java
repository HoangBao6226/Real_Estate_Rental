package com.javaweb.util;

public class NumberUtil {

	public static boolean isNumber(String db) {
		try {
			float number = Float.parseFloat(db);
		} catch (NumberFormatException e) {
			return false;
		}
		return true; 
	}
}