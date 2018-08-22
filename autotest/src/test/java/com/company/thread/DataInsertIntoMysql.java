//package com.company.thread;
//
//import com.company.utils.excel.Excel;
//import com.company.utils.excel.GetExcelFileInfo;
//import com.company.utils.pub.GetProjectInfo;
//import com.company.utils.sql.MysqlCreate;
//import com.company.utils.sql.MysqlInsert;
//import com.company.utils.sql.SQLConnection;
//
//import java.sql.Connection;
//
//public class DataInsertIntoMysql {
//	private GetExcelFileInfo getExcelFileInfo;
//	private Connection connection;
//	private MysqlCreate mysqlCreate;
//	private MysqlInsert mysqlInsert;
//	private boolean flag;
//	public DataInsertIntoMysql(){
//		this.connection=new SQLConnection().getMysqlConnection();
//		this.mysqlCreate=new MysqlCreate(connection);
//		mysqlCreate.createDataBase(GetProjectInfo.ProjectName);
//		mysqlCreate.useDataBase(GetProjectInfo.ProjectName);
//		this.mysqlInsert=new MysqlInsert(connection);
//		this.getExcelFileInfo=new GetExcelFileInfo();
//		this.flag=true;//flag为true时，内部关闭sql连接
//	}
//	public DataInsertIntoMysql(Connection connection){
//		this.connection=connection;
//		this.mysqlCreate=new MysqlCreate(connection);
//		if(!mysqlCreate.databaseExistenceDetection(GetProjectInfo.ProjectName)){
//			mysqlCreate.createDataBase(GetProjectInfo.ProjectName);
//		}
//		if(!GetProjectInfo.ProjectName.equalsIgnoreCase(mysqlCreate.getCurrentUsedDatabase())){
//			mysqlCreate.useDataBase(GetProjectInfo.ProjectName);
//		}
//		this.mysqlInsert=new MysqlInsert(connection);
//		this.getExcelFileInfo=new GetExcelFileInfo();
//		this.flag=false;//flag为true时，内部关闭sql连接
//	}
//	public void uploadElementData(){
//		for(String i:getExcelFileInfo.getElementFileName()){
//			String pageName=i.replace(".xlsx","").replace(".xls","");
//			if(!mysqlCreate.tableExistenceDetection("E_"+pageName)){
//				mysqlCreate.createTableE(pageName);
//			}
//			String[][] value=new Excel(getExcelFileInfo.elementDataPath+i,"sheet1").readExcel();
//			mysqlInsert.insertElement(pageName,value);
//		}
//	}
//	public void uploadCaseData(){
//		for(String i:getExcelFileInfo.getCasedataFileName()){
//			if(!mysqlCreate.tableExistenceDetection("testCaseData")){
//				mysqlCreate.createTableC();
//			}
//			String[][] value=new Excel(getExcelFileInfo.casedataPath+i,"sheet1").readExcel();
//			mysqlInsert.insertCase(value);
//		}
//	}
//	public void close(){
//		if(flag){
//			mysqlInsert.closestmt();
//			mysqlInsert.closeConnection();
//		}else {
//			mysqlInsert.closestmt();
//		}
//	}
//}
