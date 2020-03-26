package com.kh.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getNowDateString() {
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(now);
	}
	
	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
