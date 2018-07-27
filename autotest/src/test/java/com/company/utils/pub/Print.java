package com.company.utils.pub;

public class Print {
	public static void printArray(String[][] array){
		for(String[] i:array){
			for(String j:i){
				System.out.printf(j+"\t");
			}
			System.out.println();
		}
	}
}
