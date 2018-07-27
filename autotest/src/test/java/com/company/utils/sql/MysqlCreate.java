package com.company.utils.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlCreate extends MysqlExecute {
	public MysqlCreate(Connection connection){
		super(connection);
	}
	public void createDataBase(String dataBaseName){
		String sql="create database if not exists "+dataBaseName;
		executeUpdateUtil(1,sql);
	}
	public void useDataBase(String dataBaseName){
		String sql="use "+dataBaseName;
		executeUpdateUtil(1,sql);
	}
	public void createTableE(String PageName) {
		//controlCode,controlName,eleRecMethod,eleRoute,timeOut
		String sql = "create table if not exists E_"+PageName +"("+
				"controlCode nvarchar(40) primary key comment 'element变量名，主键，唯一识别标识符'," +
				"controlName nvarchar(40) not null comment '控件中文名'," +
				"eleRecMethod nvarchar(20) not null comment '元素识别方法css、xpath、id、name、......'," +
				"eleRoute nvarchar(500) comment '元素路径'," +
				"timeOut nvarchar(10) not null comment '显式等待超时时长'," +
				"insertName nvarchar(20) not null default ? comment '数据编辑者名称'," +
				"insertDateTime timestamp not null default now() comment '数据插入时间'," +
				"updateName nvarchar(20) not null default ? comment '数据修改着名称'," +
				"updateDateTime timestamp not null default now() comment '最近一次更新时间'," +
				"remarks nvarchar(200) comment '备注'" +
				")comment='存放元素数据，一个页面一张表'";
		executeUpdateUtil(2,sql,SQLConfig.MysqlUsername,SQLConfig.MysqlUsername);
	}
	public void createTableC(){
		String sql="create table if not exists testCaseData(" +
				"id nvarchar(20) primary key comment '主键id，用例唯一识别标识符' ," +
				"`group` nvarchar(20) not null default '0'comment '用例分组组名'," +
				"testcase text not null comment '用例步骤数据，以json形式保存为text文本'," +
				"expectedResults nvarchar(40) not null comment '期望结果'," +
				"actualResults nvarchar(40) comment '实际结果'," +
				"testResults nvarchar(10) comment '测试结果，-1未执行，0测试不通过，1测试通过'," +
				"insertName nvarchar(20) not null default ? comment '数据编辑者名称'," +
				"insertDateTime timestamp not null default now() comment '数据插入时间'," +
				"updateName nvarchar(20) not null default ? comment '数据修改者名称'," +
				"updateDateTime timestamp not null default now() comment '最近一次更新时间'," +
				"remarks nvarchar(200) comment '备注'" +
				")comment='存放用例数据'";
		executeUpdateUtil(2,sql,SQLConfig.MysqlUsername,SQLConfig.MysqlUsername);
	}
	public String getCurrentUsedDatabase(){
		//获取当前使用的库
		String database=null;
		String sql="select database()";
		executeQueryUtil(2,sql);
		try{
			resultSet.next();
			database=resultSet.getString(1);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return database;
	}

	private boolean existenceDetection(String value){
		boolean flag=false;
		try{
			resultSet.next();
			if(resultSet.getString(1).equalsIgnoreCase(value)){
				flag=true;
			}else {
				flag=false;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	public boolean databaseExistenceDetection(String databaseName){
		//判断数据库是否存在
		String sql="show databases like ?";
		executeQueryUtil(2,sql,databaseName);
		return existenceDetection(databaseName);

	}

	public boolean tableExistenceDetection(String tableName){
		//检查表格是否被创建
		String sql="show tables like ?";
		executeQueryUtil(2,sql,tableName);
		return existenceDetection(tableName);
	}
	public int getFlag(){
		return number;
	}

}
