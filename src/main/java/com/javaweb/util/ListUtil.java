package com.javaweb.util;

import java.util.List;

public class ListUtil {

	public static boolean checkList(List<String> db) {
		if(db != null && db.size() != 0)
			return true;
		return false;
	}
}