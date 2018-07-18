package com.company.utils.pub;

public class JudgePublic {
	public static boolean isNumeric(String judgmentWord){
		for (int i = 0; i < judgmentWord.length(); i++){
			if (!Character.isDigit(judgmentWord.charAt(i))){
				return false;
			}
		}
		return true;
	}
}
