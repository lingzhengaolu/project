package com.company.utils.sql;

import com.company.utils.excel.Excel;
import com.company.utils.excel.GetFieldNameIndex;
import com.company.utils.pub.CreateJSON;
import com.company.utils.pub.Time;

import java.sql.Connection;
import java.util.HashMap;

public class MysqlDataIUProcessing extends MysqlExecute {
	private GetFieldNameIndex getFieldNameIndex=new GetFieldNameIndex();
	private Time time=new Time();
	public MysqlDataIUProcessing(Connection connection){
		super(connection);
	}
	public void elementProcessing(String path,String sheetName,String pageName,String[][] value){
		Excel excel=new Excel(path,sheetName);
		HashMap<String,Integer> hashMap=getFieldNameIndex.getEleExFieldIndex(value);
		String sqlInsert="insert into E_"+pageName+"(" +
				"controlCode," +
				"controlName," +
				"eleRecMethod," +
				"eleRoute," +
				"timeOut," +
				"insertName," +
				"updateName," +
				"remarks) values(?,?,?,?,?,?,?,?)";

		String sqlUpdate="update E_"+pageName+" set " +
				"controlName=?," +
				"eleRecMethod=?," +
				"eleRoute=?," +
				"timeOut=?," +
				"remarks=?," +
				"updateName=?," +
				"updateDateTime=now() " +
				"where " +
				"controlCode=?";
		int row=value.length;
		for(int i=1;i<row;i++){
			String feedback="no operation";
			if(value[i][hashMap.get("taskType")].contains("插入")||value[i][hashMap.get("taskType")].contains("insert")) {
				executeUpdateUtil(
						2, sqlInsert,
						value[i][hashMap.get("controlCode")],
						value[i][hashMap.get("controlName")],
						value[i][hashMap.get("eleRecMethod")],
						value[i][hashMap.get("eleRoute")],
						value[i][hashMap.get("timeOut")],
						SQLConfig.MysqlUsername,
						SQLConfig.MysqlUsername,
						value[i][hashMap.get("remarks")]
				);
				feedback="Insert success";
				if(number==-1){
					feedback="插入失败，数据库可能已存在“"+value[i][hashMap.get("controlCode")]+"”主键！或者数据库失去连接！";
				}else if(number==0){
					feedback="插入0行，原因未知！";
				}
			}else if (value[i][hashMap.get("taskType")].contains("更新")||value[i][hashMap.get("taskType")].contains("update")){
				executeUpdateUtil(2,sqlUpdate,
						value[i][hashMap.get("controlName")],
						value[i][hashMap.get("eleRecMethod")],
						value[i][hashMap.get("eleRoute")],
						value[i][hashMap.get("timeOut")],
						value[i][hashMap.get("remarks")],
						SQLConfig.MysqlUsername,
						value[i][hashMap.get("controlCode")]
				);
				feedback="Update success";
				if(number==-1){
					feedback="更新失败，数据库可能失去连接！或其它未知原因！";
				}else if(number==0){
					feedback="更新0行，可能不存在：“"+value[i][hashMap.get("controlCode")]+"”字段！";
				}
			}else {
				continue;
			}
			excel.updateExcel(i,hashMap.get("feedbackResults"),feedback);
			excel.updateExcel(i,hashMap.get("taskType"),"");
		}
	}
	public void caseProcessing(String path,String sheetName,String[][] value){
		Excel excel=new Excel(path,sheetName);
		HashMap<String,Integer> hashMap=getFieldNameIndex.getCaseExFiledIndex(value);
		CreateJSON createJSON=new CreateJSON(value);
		String sqlInsert="insert into testCaseData(" +
				"id," +
				"`group`," +
				"testcase," +
				"expectedResults," +
				"actualResults," +
				"testResults," +
				"insertName," +
				"updateName," +
				"remarks) values(?,?,?,?,?,?,?,?,?)";

		String sqlUpdate="update testCaseData set " +
				"`group`=?," +
				"testcase=?," +
				"expectedResults=?," +
				"actualResults=?," +
				"updateName=?," +
				"updateDateTime=now()," +
				"remarks=? " +
				"where " +
				"id=?";

		int row=value.length;
		for(int i=1;i<row;i++){
			String feedback="no operation";
			if(value[i][hashMap.get("taskType")].contains("插入")||value[i][hashMap.get("taskType")].contains("insert")){
				executeUpdateUtil(2,sqlInsert,
						value[i][hashMap.get("id")],
						value[i][hashMap.get("group")],
						createJSON.createJson(value[i]).toString(),
						value[i][hashMap.get("expectedResults")],
						value[i][hashMap.get("actualResults")],
						value[i][hashMap.get("testResults")],
						SQLConfig.MysqlUsername,
						SQLConfig.MysqlUsername,
						value[i][hashMap.get("remarks")]
				);
				//demo
				feedback="Insert success";
				if(number==-1){
					feedback="插入失败，数据库可能已存在“"+value[i][hashMap.get("id")]+"”主键！或者数据库失去连接！";
				}else if(number==0){
					feedback="插入0行，原因未知！";
				}
			}else if (value[i][hashMap.get("taskType")].contains("更新")||value[i][hashMap.get("taskType")].contains("update")){
				executeUpdateUtil(2,sqlUpdate,
						value[i][hashMap.get("group")],
						createJSON.createJson(value[i]).toString(),
						value[i][hashMap.get("expectedResults")],
						value[i][hashMap.get("actualResults")],
						SQLConfig.MysqlUsername,
						value[i][hashMap.get("remarks")],
						value[i][hashMap.get("id")]
				);
				feedback="Update success";
				if(number==-1){
					feedback="更新失败，数据库可能失去连接！或其它未知原因！";
				}else if(number==0){
					feedback="更新0行，可能不存在：“"+value[i][hashMap.get("id")]+"”字段！";
				}
			}else {
				continue;
			}
			excel.updateExcel(i,hashMap.get("feedbackResults"),feedback);
			excel.updateExcel(i,hashMap.get("taskType"),"");
		}
	}

	public void updateTestResults(String id,String actualResults,String testResults){
		String sqlUpdate="update testCaseData set " +
				"actualResults=?," +
				"testResults=?," +
				"updateName=?," +
				"updateDateTime=now() " +
				"where " +
				"id=?";
		executeUpdateUtil(2,sqlUpdate,
				actualResults,
				testResults,
				SQLConfig.MysqlUsername,
				id
		);
	}

}
