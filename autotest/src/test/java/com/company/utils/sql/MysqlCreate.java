package com.company.utils.sql;

import java.sql.Connection;

public class MysqlCreate extends MysqlStatement {
	public MysqlCreate(Connection connection){
		super(connection);
	}
	public void createDataBase(String dataBaseName){
		String sql="create database if not exists"+
				" "+
				dataBaseName;
		executeUpdateUtil(sql);
	}
	public void useDataBase(String dataBaseName){
		String sql="use"+
				" "+
				dataBaseName;
		executeUpdateUtil(sql);
	}
	public void createTable(String tableName) {
		//controlCode,controlName,eleRecMethod,eleRoute,timeOut
		String sql = "create table if not exists" +
				" " +
				tableName +
				"(controlCode nvarchar(40) primary key ," +
				"controlName nvarchar(40) not null ," +
				"eleRecMethod nvarchar(20) not null ," +
				"eleRoute nvarchar(500)," +
				"timeOut nvarchar(10) not null)";
		executeUpdateUtil(sql);
	}
	public int getFlag(){
		return number;
	}

}
