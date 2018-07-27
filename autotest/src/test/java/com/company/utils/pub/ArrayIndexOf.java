package com.company.utils.pub;


public class ArrayIndexOf {
	public static int arrayIndex(String[] array,String value){
		int index;
		int length=array.length;
		for(int i=0;i<length;i++){
			if(array[i].equalsIgnoreCase(value)){
				//忽略大小写
				return i;
			}
		}
		return -1;
	}
}
