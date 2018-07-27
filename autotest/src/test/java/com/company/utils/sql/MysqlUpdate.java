package com.company.utils.sql;

import com.company.utils.pub.CreateJSON;
import com.company.utils.excel.GetFieldNameIndex;
import com.company.utils.pub.Time;

import java.sql.Connection;
import java.util.HashMap;

public class MysqlUpdate extends MysqlExecute{
	//后续处理更新状态
	private GetFieldNameIndex getFieldNameIndex=new GetFieldNameIndex();
	private Time time=new Time();
	public MysqlUpdate(Connection connection){
		super(connection);
	}
	public void updateElement(String pageName,String[][] value){
		HashMap<String,Integer> hashMap=getFieldNameIndex.getEleExFieldIndex(value);
		String sql="update E_"+pageName+" set " +
				"controlName=?," +
				"eleRecMethod=?," +
				"eleRoute=?," +
				"timeOut=?," +
				"remarks=?," +
				"updateName=?," +
				"updateDateTime=? " +
				"where " +
				"controlCode=?";
		int row=value.length;
		for(int i=1;i<row;i++){
			if(value[i][hashMap.get("taskType")].contains("update")||value[i][hashMap.get("taskType")].contains("更新")){
				executeUpdateUtil(2,sql,
						value[i][hashMap.get("controlName")],
						value[i][hashMap.get("eleRecMethod")],
						value[i][hashMap.get("eleRoute")],
						value[i][hashMap.get("timeOut")],
						value[i][hashMap.get("remarks")],
						SQLConfig.MysqlUsername,
						time.getNowTime(),
						value[i][hashMap.get("controlCode")]
				);
			}
		}
	}
	public void updateCaseData(String[][] value){
		HashMap<String,Integer> hashMap=getFieldNameIndex.getCaseExFiledIndex(value);
		CreateJSON createJSON=new CreateJSON(value);
		String sql="update testCaseData set " +
				"`group`=?," +
				"testcase=?," +
				"expectedResults=?," +
				"actualResults=?," +
				"updateName=?," +
				"updateDateTime=?," +
				"remarks=? " +
				"where " +
				"id=?";
		int row=value.length;
		for(int i=1;i<row;i++){
			if(value[i][hashMap.get("taskType")].contains("update")||value[i][hashMap.get("taskType")].contains("更新")){
				executeUpdateUtil(2,sql,
						value[i][hashMap.get("group")],
						createJSON.createJson(value[i]).toString(),
						value[i][hashMap.get("expectedResults")],
						value[i][hashMap.get("actualResults")],
						SQLConfig.MysqlUsername,
						time.getNowTime(),
						value[i][hashMap.get("remarks")],
						value[i][hashMap.get("id")]
				);
			}
		}
	}
	public void updateTestResults(String id,String actualResults,String testResults){
		String sql="update testCaseData set " +
				"actualResults=?," +
				"testResults=?," +
				"updateName=?," +
				"updateDateTime=? " +
				"where " +
				"id=?";
		executeUpdateUtil(2,sql,
				actualResults,
				testResults,
				SQLConfig.MysqlUsername,
				time.getNowTime(),
				id
		);
	}
	public int getNumber(){
		return number;
	}
}
