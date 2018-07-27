package com.company.utils.excel;

import com.company.utils.pub.ArrayIndexOf;
import com.company.utils.ui.box.ErrorDialog;

import java.util.HashMap;

public class GetFieldNameIndex {
	public HashMap<String,Integer> getEleExFieldIndex(String[][] value){
		int controlCode=ArrayIndexOf.arrayIndex(value[0],"controlCode");
		int controlName=ArrayIndexOf.arrayIndex(value[0],"controlName");
		int eleRecMethod=ArrayIndexOf.arrayIndex(value[0],"eleRecMethod");
		int eleRoute=ArrayIndexOf.arrayIndex(value[0],"eleRoute");
		int timeOut=ArrayIndexOf.arrayIndex(value[0],"timeOut");
		int taskType=ArrayIndexOf.arrayIndex(value[0],"taskType");
		int remarks=ArrayIndexOf.arrayIndex(value[0],"remarks");
		int feedbackResults=ArrayIndexOf.arrayIndex(value[0],"feedbackResults");
		if(controlCode==-1||controlName==-1||eleRecMethod==-1||eleRoute==-1||timeOut==-1||taskType==-1||remarks==-1||feedbackResults==-1){
			ErrorDialog.errorDialog("数据检查","二维数组字段名错误，请检查！" +
					"目标字段名：controlCode,controlName,eleRecMethod,eleRoute,timeOut,taskType,remarks,feedbackResults");
			System.exit(0);
		}
		HashMap<String,Integer> hashMap=new HashMap<>();
		hashMap.put("controlCode",controlCode);
		hashMap.put("controlName",controlName);
		hashMap.put("eleRecMethod",eleRecMethod);
		hashMap.put("eleRoute",eleRoute);
		hashMap.put("timeOut",timeOut);
		hashMap.put("taskType",taskType);
		hashMap.put("remarks",remarks);
		hashMap.put("feedbackResults",feedbackResults);

		return hashMap;
	}
	public HashMap<String,Integer> getCaseExFiledIndex(String[][] value){
		int id=ArrayIndexOf.arrayIndex(value[0],"id");
		int group=ArrayIndexOf.arrayIndex(value[0],"group");
		int expectedResults=ArrayIndexOf.arrayIndex(value[0],"expectedResults");
		int actualResults=ArrayIndexOf.arrayIndex(value[0],"actualResults");
		int testResults=ArrayIndexOf.arrayIndex(value[0],"testResults");
		int taskType=ArrayIndexOf.arrayIndex(value[0],"taskType");
		int remarks=ArrayIndexOf.arrayIndex(value[0],"remarks");
		int feedbackResults=ArrayIndexOf.arrayIndex(value[0],"feedbackResults");
		if(id==-1||group==-1||expectedResults==-1||actualResults==-1||taskType==-1||remarks==-1||testResults==-1||feedbackResults==-1){
			ErrorDialog.errorDialog("数据检查","二维数组字段名错误，请检查！" +
					"目标字段名：id,group,expectedResults,actualResults,testResults,taskType,remarks,feedbackResults");
			System.exit(0);
		}
		HashMap<String,Integer> hashMap=new HashMap<>();
		hashMap.put("id",id);
		hashMap.put("group",group);
		hashMap.put("expectedResults",expectedResults);
		hashMap.put("actualResults",actualResults);
		hashMap.put("testResults",testResults);
		hashMap.put("taskType",taskType);
		hashMap.put("remarks",remarks);
		hashMap.put("feedbackResults",feedbackResults);

		return hashMap;
	}
}
