package com.company.utils.pub;

import java.util.Random;

public class ArrayIndexOf {
	public static int arrayIndex(String[] array,String value){
		int index;
		int length=array.length;
		for(int i=0;i<length;i++){
			if(array[i].equals(value)){
				return i;
			}
		}
		return -1;
	}
}
