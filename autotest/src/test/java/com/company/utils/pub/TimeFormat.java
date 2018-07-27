package com.company.utils.pub;


public class TimeFormat {
	public static String getTimeFormat(String str){
		String format;
		switch (str){
			case "ymdhms":
			case "YMDHMS":
			case "yyyy-MM-dd HH:mm:ss":
				format="yyyy-MM-dd HH:mm:ss";
				break;
			case "ymd":
			case "YMD":
			case "yyyy-MM-dd":
				format="yyyy-MM-dd";
				break;
			case "hms":
			case "HMS":
			case "HH:mm:ss":
				format="HH:mm:ss";
				break;
			default:
				format="yyyy-MM-dd HH:mm:ss";
				break;
		}
		return format;
	}
}
