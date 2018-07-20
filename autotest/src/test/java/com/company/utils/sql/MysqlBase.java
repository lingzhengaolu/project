package com.company.utils.sql;

import java.sql.Connection;

public class MysqlBase extends MysqlStatement{
	public MysqlBase(Connection connection){
		super(connection);
	}
	public void insert(String tableName,String [][] value){
//		String controlCode=null;
//		String controlName=null;
//		String eleRecMethod=null;
//		String eleRoute=null;
//		String timeOut=null;
//
//		String sql="insert into"+
//				" "+
//				tableName+
//				"(controlCode,controlName,eleRecMethod,eleRoute,timeOut) values("+
//		controlCode+","+
//		controlName+","+
//		eleRecMethod+","+
//		eleRoute+","+
//		timeOut+")";
	}
}
