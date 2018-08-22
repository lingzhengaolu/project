package com.company.dataprocessing;

import com.company.utils.excel.Excel;
import com.company.utils.excel.GetExcelFileInfo;
import com.company.utils.pub.GetProjectInfo;
import com.company.utils.sql.MysqlCreate;
import com.company.utils.sql.MysqlDataIUProcessing;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class DataUploadToMysql extends MysqlDataIUProcessing{
	private final String sheet="sheet1";
	private GetExcelFileInfo getExcelFileInfo;
	private MysqlDataIUProcessing mysqlDataIUProcessing;
	private MysqlCreate mysqlCreate;
	public DataUploadToMysql(Connection connection){
		super(connection);
		this.getExcelFileInfo=new GetExcelFileInfo();
		this.mysqlDataIUProcessing=new MysqlDataIUProcessing(connection);
		this.mysqlCreate=new MysqlCreate(connection);
		if(!GetProjectInfo.ProjectName.equalsIgnoreCase(mysqlCreate.getCurrentUsedDatabase())){
			mysqlCreate.useDataBase(GetProjectInfo.ProjectName);
		}
	}
	public void uploadElenemt(){
		ArrayList<String> filesInfo=getExcelFileInfo.getElementFileName();
		for(String i:filesInfo){
			String pageName=i.replace(".xlsx","").replace(".xls","");
			if(!mysqlCreate.tableExistenceDetection("E_"+pageName)){
				mysqlCreate.createTableE(pageName);
			}
			String[][] value=new Excel(getExcelFileInfo.elementDataPath+i,sheet).readExcel();
			mysqlDataIUProcessing.elementProcessing(getExcelFileInfo.elementDataPath+i,sheet,pageName,value);
		}
		mysqlDataIUProcessing.closestmt();
		filesInfo.clear();
	}
	public void uploadCase(){
		ArrayList<String> filesInfo=getExcelFileInfo.getCasedataFileName();
		if(!mysqlCreate.tableExistenceDetection("testCaseData")){
			mysqlCreate.createTableC();
		}
		for(String i:filesInfo){
			String[][] value=new Excel(getExcelFileInfo.casedataPath+i,sheet).readExcel();
			mysqlDataIUProcessing.caseProcessing(getExcelFileInfo.casedataPath+i,sheet,value);
		}
		mysqlDataIUProcessing.closestmt();
		filesInfo.clear();
	}
}

