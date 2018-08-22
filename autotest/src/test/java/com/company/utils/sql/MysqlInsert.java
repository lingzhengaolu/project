package com.company.utils.sql;

import com.company.utils.pub.CreateJSON;
import com.company.utils.excel.GetFieldNameIndex;

import java.sql.Connection;
import java.util.HashMap;

public class
MysqlInsert extends MysqlExecute{
	//后续处理插入状态
	private GetFieldNameIndex getFieldNameIndex=new GetFieldNameIndex();
	public MysqlInsert(Connection connection){
		super(connection);
	}
	public void insertElement(String pageName,String [][] value){
		HashMap<String,Integer> hashMap=getFieldNameIndex.getEleExFieldIndex(value);
		String sql="insert into E_"+pageName+"(controlCode,controlName,eleRecMethod,eleRoute,timeOut,remarks) values(?,?,?,?,?,?)";
		int row=value.length;
		for(int i=1;i<row;i++){
			if(value[i][hashMap.get("taskType")].contains("插入")||value[i][hashMap.get("taskType")].contains("insert")){
				executeUpdateUtil(
						2, sql,
						value[i][hashMap.get("controlCode")],
						value[i][hashMap.get("controlName")],
						value[i][hashMap.get("eleRecMethod")],
						value[i][hashMap.get("eleRoute")],
						value[i][hashMap.get("timeOut")],
						value[i][hashMap.get("remarks")]
				);
			}
		}

	}
	public void insertCase(String[][] value){
		CreateJSON createJSON=new CreateJSON(value);
		HashMap<String,Integer> hashMap=getFieldNameIndex.getCaseExFiledIndex(value);
		String sql="insert into testCaseData(id,`group`,testcase,expectedResults,actualResults,testResults,remarks) values(?,?,?,?,?,?,?)";
		int row=value.length;
		for(int i=1;i<row;i++){
			if(value[i][hashMap.get("taskType")].contains("插入")||value[i][hashMap.get("taskType")].contains("insert")){
				executeUpdateUtil(2,sql,
						value[i][hashMap.get("id")],
						value[i][hashMap.get("group")],
						createJSON.createJson(value[i]).toString(),
						value[i][hashMap.get("expectedResults")],
						value[i][hashMap.get("actualResults")],
						value[i][hashMap.get("testResults")],
						value[i][hashMap.get("remarks")]
				);
			}
		}
	}
	public int getNumber(){
		return number;
	}
}
