package com.company.thread;

import com.company.utils.excel.Excel;
import com.company.utils.excel.GetExcelFileInfo;
import com.company.utils.pub.GetProjectInfo;
import com.company.utils.sql.MysqlCreate;
import com.company.utils.sql.MysqlUpdate;
import com.company.utils.sql.SQLConnection;

import java.sql.Connection;

public class UpdateMysqlData {
	private GetExcelFileInfo getExcelFileInfo;
	private Connection connection;
	private MysqlCreate mysqlCreate;
	private MysqlUpdate mysqlUpdate;
	private boolean flag;
	public UpdateMysqlData(){
		this.connection=new SQLConnection().getMysqlConnection();
		this.mysqlCreate=new MysqlCreate(connection);
		mysqlCreate.useDataBase(GetProjectInfo.ProjectName);
		this.mysqlUpdate=new MysqlUpdate(connection);
		this.getExcelFileInfo=new GetExcelFileInfo();
		this.flag=true;//flag为true时，内部关闭sql连接
	}
	public UpdateMysqlData(Connection connection){
		this.connection=connection;
		this.mysqlCreate=new MysqlCreate(connection);
		if(mysqlCreate.getCurrentUsedDatabase().equalsIgnoreCase(GetProjectInfo.ProjectName)){
			mysqlCreate.useDataBase(GetProjectInfo.ProjectName);
		}
		this.mysqlUpdate=new MysqlUpdate(connection);
		this.getExcelFileInfo=new GetExcelFileInfo();
		this.flag=false;//flag为true时，内部关闭sql连接
	}
	public void updateElement(){
		for(String i:getExcelFileInfo.getElementFileName()){
			String pageName=i.replace(".xlsx","").replace(".xls","");
			String[][] value=new Excel(getExcelFileInfo.elementDataPath+i,"sheet1").readExcel();
			mysqlUpdate.updateElement(pageName,value);
		}
	}
	public void updateCase(){
		for(String i:getExcelFileInfo.getCasedataFileName()){
			String[][] value=new Excel(getExcelFileInfo.casedataPath+i,"sheet1").readExcel();
			mysqlUpdate.updateCaseData(value);
		}
	}
	public void close(){
		if(flag){
			mysqlUpdate.closestmt();
			mysqlUpdate.closeConnection();
		}else {
			mysqlUpdate.closestmt();
		}
	}

}
