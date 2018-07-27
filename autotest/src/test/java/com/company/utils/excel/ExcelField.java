package com.company.utils.excel;

public class ExcelField {
	public  String[][] elementField(){
		String[][] filed=new String[][]{
				{"controlCode","controlName","eleRecMethod","eleRoute","timeOut","taskType","remarks","feedbackResults"},
				{"null","null","null","null","null","null","null","null"}
		};
		return filed;
	}
	public String[][] casedataField(){
		String[][] filed=new String[][]{
				{"id","group","用例数据占n个字段","expectedResults","actualResults","testResults","taskType","remarks","feedbackResults"},
				{"null","null","null","null","null","null","null","null","null"}
		};
		return filed;
	}
}
