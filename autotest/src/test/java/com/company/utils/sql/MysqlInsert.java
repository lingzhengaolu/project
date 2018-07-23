package com.company.utils.sql;

import com.company.utils.pub.ArrayIndexOf;
import com.company.utils.ui.promptbox.ErrorDialog;

import java.sql.Connection;

public class MysqlInsert extends MysqlExecute{
	public MysqlInsert(Connection connection){
		super(connection);
	}
	public void insertElement(String tableName,String [][] value){
		int controlCode=ArrayIndexOf.arrayIndex(value[0],"controlCode");
		int controlName=ArrayIndexOf.arrayIndex(value[0],"controlName");
		int eleRecMethod=ArrayIndexOf.arrayIndex(value[0],"eleRecMethod");
		int eleRoute=ArrayIndexOf.arrayIndex(value[0],"eleRoute");
		int timeOut=ArrayIndexOf.arrayIndex(value[0],"timeOut");
		if(controlCode==-1||controlName==-1||eleRecMethod==-1||eleRoute==-1||timeOut==-1){
			ErrorDialog.errorDialog("数据检查","二维数组字段名错误，请检查！" +
					"目标字段名：controlCode,controlName,eleRecMethod,eleRoute,timeOut");
			System.exit(0);
		}
		String sql="insert into "+tableName+"(controlCode,controlName,eleRecMethod,eleRoute,timeOut) values(?,?,?,?,?)";
		MysqlExecute mysqlExecute=new MysqlExecute(connection);
		int row=value.length;
		for(int i=1;i<row;i++){
			mysqlExecute.executeUpdateUtil(2,sql,value[i][controlCode],value[i][controlName],value[i][eleRecMethod],value[i][eleRoute],value[i][timeOut]);
		}

	}
}
