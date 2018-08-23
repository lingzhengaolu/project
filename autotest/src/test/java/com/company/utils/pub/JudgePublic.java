package com.company.utils.pub;

import java.util.ArrayList;

public class JudgePublic {
	public static boolean isNumeric(String judgmentWord){
		for (int i = 0; i < judgmentWord.length(); i++){
			if (!Character.isDigit(judgmentWord.charAt(i))){
				return false;
			}
		}
		return true;
	}
	public static boolean isExcel(String path){
		if(!path.endsWith(".xls")||!path.endsWith("xlsx")){
			System.out.println("文件格式错误，非标准的excel文件！");
//			System.exit(0);
			return false;
		}
		return true;
	}
//	public static boolean arrayContainsValue(ArrayList<Object> arrayList,Object value){
//
//	}
//
//	public static boolean arrayAllValue(ArrayList<Object> arrayList,Object value){
//
//	}
}
